/**
 * cartService.js
 */

const svc = {
	// 장바구니 목록.
	cartList(successCall, errorCall) {
		fetch('cartList.do')
			.then(resolve => resolve.json()) // json문자->객체.
			.then(successCall)
			.catch(errorCall);
	},
	//장바구니 업데이트
	cartUpdate(cvo = {}, successCall, errorCall) {
		fetch('editCart.do', {
			method: 'post',
			headers: { 'Content-Type': 'application/x-www-form-urlencoded' },
			body: 'no=' + cvo.no + '&qty=' + cvo.qty
		})
			.then(resolve => resolve.json())
			.then(successCall)
			.catch(errorCall);
	},
	//장바구니 상품 삭제
	cartRemove(no = 1, successCall, errorCall) {
		fetch('delCart.do', {
			method: 'post',
			headers: { 'Content-Type': 'application/x-www-form-urlencoded' },
			body: 'no=' + no
		})
			.then(resolve => resolve.json())
			.then(successCall)
			.catch(errorCall);
	}
}