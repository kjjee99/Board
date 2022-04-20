let form = document.getElementById("form");
let inputID = document.getElementById("input-id");
let inputPW = document.getElementById("input-pw");
let inputName = document.getElementById("input-name");

form.addEventListener("submit", function(event) {
	if (inputID.vaule == "" || inputPW.value == "" || inputName.value == "") {
		window.alert(`값을 입력하세요`);
		event.preventDefault();
	}
})


