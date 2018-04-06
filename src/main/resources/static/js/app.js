var taskManagerModule = angular.module('todoApp', ['ngAnimate']);

taskManagerModule.controller('todoController', function ($scope,$http) {
	
	var urlBase="";
	
	$scope.selection = [];
	$scope.statuses=['PENDING','COMPLETED'];
	$http.defaults.headers.post["Content-Type"] = "application/json";

    function findAllTasks() {
        //get all tasks and display initially
        $http({
        	 method: 'get', 
        	   url: urlBase + '/tasks/search/findByArchived?archivedfalse=0'
        	
              }).then(function (response) {
            	 // alert(data);
                if (response.data._embedded != undefined) {
                	//alert(data._embedded.tasks);
                    $scope.tasks = response.data._embedded.tasks;
                } else {
                    $scope.tasks = [];
                }
                for (var i = 0; i < $scope.tasks.length; i++) {
                    if ($scope.tasks[i].status == 'COMPLETED') {
                        $scope.selection.push($scope.tasks[i]._links.self.href);
                    }
                }
                $scope.name="";
                $scope.desc="";
                $scope.status="";
               
            });
    }

    findAllTasks();

	//add a new task
	$scope.addTask = function addTask() {
		if($scope.name=="" || $scope.desc==""  || $scope.status == ""){
			alert("Please provide values for  name, description and status");
		}
		else{
		 $http({
			 method:'post',
			 url : urlBase + '/tasks', 
			 data:{name: $scope.name,
             description: $scope.desc,
             status: $scope.status
			 }
		 }).then(function(data, status, headers) {
			 alert("Task added");
			 $scope.name="";
             $scope.desc="";
             $scope.status="";
             
             findAllTasks();
		    });
		}
	};
		
	// toggle selection for a given task by task id
	  $scope.toggleSelection = function toggleSelection(taskUri) {
	    var idx = $scope.selection.indexOf(taskUri);

	    // is currently selected
       
	    if (idx > -1) {
	      $http({method:'put',
	    	  url:taskUri, 
	    	  data:{ status: 'PENDING' }
	      }).then (function(data) {
		      alert("Todo unmarked");
              findAllTasks();
		    });
	      $scope.selection.splice(idx, 1);
	    }

	    // is newly selected
        // HTTP PATCH to COMPLETED state
	    else {
	    	//alert(taskUri);
	      $http({method:'patch',url:taskUri, data:{ status: 'COMPLETED' }}).
		  then(function(data) {
			  alert("Todo marked completed");
              findAllTasks();
		    });
	      $scope.selection.push(taskUri);
	    }
	  };
	  
	
	// Archive Completed Tasks
	  $scope.archiveTasks = function archiveTasks() {
          $scope.selection.forEach(function(taskUri) {
        	  //alert(taskUri);
              if (taskUri != undefined) {
                  $http({method:'patch',url:taskUri, data:{ archived: 1}});
              }
          });
          alert("Successfully Archived");
          findAllTasks();
	  };
	
});

//Angularjs Directive for confirm dialog box
taskManagerModule.directive('ngConfirmClick', [
	function(){
         return {
             link: function (scope, element, attr) {
                 var msg = attr.ngConfirmClick || "Are you sure?";
                 var clickAction = attr.confirmedClick;
                 element.bind('click',function (event) {
                     if ( window.confirm(msg) ) {
                         scope.$eval(clickAction);
                     }
                 });
             }
         };
 }]);