"use strict";

function addQuantity(productId) {
  const xhttp = new XMLHttpRequest();
  xhttp.onreadystatechange = function() {
    if (this.readyState === 4 && this.status === 200) {
      const parsedRes = JSON.parse(this.responseText);
      console.log(this.responseText);
      
      /*
      if (parsedRes.error) {
        return displayError(parsedRes.message);
      }
      if (!parsedRes.success) {
        return message.innerHTML = parsedRes.message;
      }
      */
      //location.href = '/home';
      window.location.reload();
    }
  };
  xhttp.open("POST", "/order/quantity/add", true);
  xhttp.setRequestHeader("Content-Type", "application/json");
  const product = JSON.stringify({
    id: productId,
  });
  console.log(product);
  xhttp.send(product);
}

function addQuantity(productId) {
	  const xhttp = new XMLHttpRequest();
	  xhttp.onreadystatechange = function() {
	    if (this.readyState === 4 && this.status === 200) {
	      const parsedRes = JSON.parse(this.responseText);
	      console.log(this.responseText);
	      
	      /*
	      if (parsedRes.error) {
	        return displayError(parsedRes.message);
	      }
	      if (!parsedRes.success) {
	        return message.innerHTML = parsedRes.message;
	      }
	      */
	      //location.href = '/home';
	      window.location.reload();
	    }
	  };
	  xhttp.open("POST", "/order/quantity/add", true);
	  xhttp.setRequestHeader("Content-Type", "application/json");
	  const product = JSON.stringify({
	    id: productId,
	  });
	  console.log(product);
	  xhttp.send(product);
	}

