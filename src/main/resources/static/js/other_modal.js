
// 모달 키기/끄기 관련 변수---------------------------------------------------------

// 모달을 키는 버튼을 모두(중복되는 버튼까지) 가져옴
let open = document.querySelectorAll(".other__modal");
// modal hidden클래스의 modal클래스만 가져옴
let otherModal = document.querySelector(".other_modal");
// close_button을 가져옴
let closeButton = otherModal.querySelector(".close_btn");
// -----------------------------------------------------
// 모달을 켜주는 함수
const openOtherModal = () => {
    // modal의 hidden클래스를 지워줌으로서 display:none효과가 없어지면서 모달이 나타남
    otherModal.classList.remove("hidden")
};
// 모달을 꺼주는 함수
const closeOtherModal = () =>{
    // modal에 hidden클래스를 추가해줌으로서 display:none효과가 적용되어 모달이 사라짐
    otherModal.classList.add("hidden")
    // 드래그로 옮겨진 모달을 원래 위치로 복귀시킴
    // (만약 modal__contents의 top left값이 바뀐다면 밑에 wrap.style.top의 값과 wrap.style.left를 바꿔줘야한다)
    content.style.top = `100px`;
    content.style.left = `700px`;
}

[].forEach.call(open, function(col) {
    col.addEventListener("click", openOtherModal);
});
// closeBtn을 누르면 모달을 닫아줌
closeButton.addEventListener("click", closeOtherModal);

let content = document.querySelector(".modal__content");
let other_header = document.querySelector(".other__modal__header");
let recentX = 0;
let recentY = 0;
let pastX = 0;
let pastY = 0;

// 1. 마우스다운시 실행되는 이벤트
other_header.addEventListener('mousedown', function(e){
    e.preventDefault();
    // 현재 클라이언트의 가로값을 가지고 온다
    pastX = e.clientX;
    // 현재 클라이언트의 세로값을 가지고 온다
    pastY = e.clientY;

    // 2.
    other_header.classList.add('active');

    // 3. 마우스 클릭이 끝나는 시점에 onRemoveEvent함수 호출
    document.addEventListener('mouseup', onRemoveEvent);

    // 4. 마우스가 드래그되는 시점에 onMove함수 호출
    document.addEventListener('mousemove', onMove);
});

function onRemoveEvent() {
    other_header.classList.remove('active');
    document.removeEventListener('mouseup', onRemoveEvent);
    document.removeEventListener('mousemove', onMove);
}

function onMove(e) {
    e.preventDefault();
    recentX = pastX - e.clientX;
    recentY = pastY - e.clientY;

    pastX = e.clientX;
    pastY = e.clientY;

    content.style.top = `${content.offsetTop - recentY}px`;
    content.style.left = `${content.offsetLeft - recentX}px`;
}