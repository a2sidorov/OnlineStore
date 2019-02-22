"use strict";

function addToCart(productId) {
	let orders = [];
	try {
		orders = JSON.parse(document.cookie);
		let isFound = false;
		
		orders.forEach(order => {
			if (productId === order.productId) {
				order.qty++;
				isFound = true;
			}
		});
		
		if (!isFound) {
			orders.push({productId: productId, qty: 1});
		}
		
	} catch (e) {
		orders = [{productId: productId, qty: 1}];
	}
	document.cookie = JSON.stringify(orders);
	console.log(document.cookie);
}
