"use strict";

function subtractQuantity() {
	const quantity = document.getElementById("quantity");
	let value = quantity.innerHTML;
	value = parseInt(value) - 1 > 0 ? value - 1 : value;
	quantity.innerHTML = value;
	document.getElementById("quantityInput").value = value;
}

function addQuantity() {
	const quantity = document.getElementById("quantity");
	let value = parseInt(quantity.innerHTML) + 1;
	quantity.innerHTML = value;
	document.getElementById("quantityInput").value = value;
}