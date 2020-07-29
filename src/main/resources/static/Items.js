angular.module('demo', []).controller('Hello', function($scope, $http) {
	$http.get('http://localhost:8080/getAllItems').then(function(response) {
		$scope.itemArray = response.data;
	});
	$http.get('http://localhost:8080/getAllBuyer').then(function(response) {
		$scope.buyerArray = response.data;
	});
	$scope.buyerId="";
	$scope.itemToAdd="";
	$scope.qntyToadd=0;
	$scope.buyerAdd={"buyerName":"","address":"","gstin":""};
	$scope.change1 = function(item) {
		$scope.order = {};
		$scope.order["itemId"] = item.id;
		$scope.order["quantity"] = item.quantity;
	}
	$scope.tableArray = []
	$scope.addItem = function() {
		let itemAdd= $scope.itemArray.find(s=>s.id==$scope.itemToAdd);
		let amt=($scope.qntyToadd*itemAdd.price)
		$scope.tableArray.push({
			"itemName":itemAdd.itemName, "qtny":$scope.qntyToadd, "price":itemAdd.price,
			"amount":amt
		});
	}
	
	$scope.selectBuyer = function() {
		$scope.buyerAdd= $scope.buyerArray.find(s=>s.id==$scope.buyerId);
		
	}
	
	$scope.calculateAmount = function() {
		let tableArrayCalculate= angular.copy($scope.tableArray);
		let sum=0;
		angular.forEach(tableArrayCalculate, function (value, key) { 
			sum+=(value.amount)
        });
		$scope.totalSum=sum;
		$scope.cgstAmount= .09*sum;
		$scope.sgstAmount= .09*sum;
		$scope.finalSum=sum+$scope.cgstAmount+$scope.sgstAmount;
		var price=$scope.finalSum;
		var sglDigit = ["Zero", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"],
		    dblDigit = ["Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"],
		    tensPlace = ["", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"],
		    handle_tens = function(dgt, prevDgt) {
		      return 0 == dgt ? "" : " " + (1 == dgt ? dblDigit[prevDgt] : tensPlace[dgt])
		    },
		    handle_utlc = function(dgt, nxtDgt, denom) {
		      return (0 != dgt && 1 != nxtDgt ? " " + sglDigit[dgt] : "") + (0 != nxtDgt || dgt > 0 ? " " + denom : "")
		    };

		  var str = "",
		    digitIdx = 0,
		    digit = 0,
		    nxtDigit = 0,
		    words = [];
		  if (price += "", isNaN(parseInt(price))) str = "";
		  else if (parseInt(price) > 0 && price.length <= 10) {
		    for (digitIdx = price.length - 1; digitIdx >= 0; digitIdx--) switch (digit = price[digitIdx] - 0, nxtDigit = digitIdx > 0 ? price[digitIdx - 1] - 0 : 0, price.length - digitIdx - 1) {
		      case 0:
		        words.push(handle_utlc(digit, nxtDigit, ""));
		        break;
		      case 1:
		        words.push(handle_tens(digit, price[digitIdx + 1]));
		        break;
		      case 2:
		        words.push(0 != digit ? " " + sglDigit[digit] + " Hundred" + (0 != price[digitIdx + 1] && 0 != price[digitIdx + 2] ? " and" : "") : "");
		        break;
		      case 3:
		        words.push(handle_utlc(digit, nxtDigit, "Thousand"));
		        break;
		      case 4:
		        words.push(handle_tens(digit, price[digitIdx + 1]));
		        break;
		      case 5:
		        words.push(handle_utlc(digit, nxtDigit, "Lakh"));
		        break;
		      case 6:
		        words.push(handle_tens(digit, price[digitIdx + 1]));
		        break;
		      case 7:
		        words.push(handle_utlc(digit, nxtDigit, "Crore"));
		        break;
		      case 8:
		        words.push(handle_tens(digit, price[digitIdx + 1]));
		        break;
		      case 9:
		        words.push(0 != digit ? " " + sglDigit[digit] + " Hundred" + (0 != price[digitIdx + 1] || 0 != price[digitIdx + 2] ? " and" : " Crore") : "")
		    }
		    str = words.reverse().join("") + " Only";
		  } else str = "";
		 $scope.printInwords=str;
		}
	
	
	
	$scope.submitOrder = function() {

		$scope.postValue = [];
		$http({
			method : 'POST',
			url : 'http://localhost:8080/saveOrder',
			data : $scope.order
		}).then(function(response) {
			$scope.msg = response.data;
		});
	}
});
