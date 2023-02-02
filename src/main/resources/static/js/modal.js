
// 모달 키기/끄기 관련 변수---------------------------------------------------------

// 모달을 키는 버튼을 모두(중복되는 버튼까지) 가져옴
const openButton = document.querySelectorAll(".modal__open");
// modal hidden클래스의 modal클래스만 가져옴
const modal = document.querySelector(".modal");
// close_button을 가져옴
const closeBtn = modal.querySelector(".close_button");
const closeBtn1 = modal.querySelector(".close_button1");
// -----------------------------------------------------
// 모달을 켜주는 함수
const openModal = () =>{
    // modal의 hidden클래스를 지워줌으로서 display:none효과가 없어지면서 모달이 나타남
    modal.classList.remove("hidden")
};
// 모달을 꺼주는 함수
const closeModal = () =>{
    // modal에 hidden클래스를 추가해줌으로서 display:none효과가 적용되어 모달이 사라짐
    modal.classList.add("hidden")
    // 드래그로 옮겨진 모달을 원래 위치로 복귀시킴
    // (만약 modal__contents의 top left값이 바뀐다면 밑에 wrap.style.top의 값과 wrap.style.left를 바꿔줘야한다)
    wrap.style.top = `100px`;
    wrap.style.left = `700px`;

}
// foreach문으로 openButton배열에 담긴 모든 버튼을 모두 선택 할 수있게 해줌
[].forEach.call(openButton, function(col) {
    col.addEventListener("click", openModal);

});
// closeBtn을 누르면 모달을 닫아줌
closeBtn.addEventListener("click", closeModal);
closeBtn1.addEventListener("click", closeModal);



const wrap = document.querySelector(".modal__contents");
const header = document.querySelector(".modal__header");
let lastX = 0;
let lastY = 0;
let startX = 0;
let startY = 0;

// 1. 마우스다운시 실행되는 이벤트
header.addEventListener('mousedown', function(e){
    e.preventDefault();
    // 현재 클라이언트의 가로값을 가지고 온다
    startX = e.clientX;
    // 현재 클라이언트의 세로값을 가지고 온다
    startY = e.clientY;

    // 2.
    header.classList.add('active');

    // 3. 마우스 클릭이 끝나는 시점에 onRemoveEvent함수 호출
    document.addEventListener('mouseup', onRemoveEvent);

    // 4. 마우스가 드래그되는 시점에 onMove함수 호출
    document.addEventListener('mousemove', onMove);
});

function onRemoveEvent() {
    header.classList.remove('active');
    document.removeEventListener('mouseup', onRemoveEvent);
    document.removeEventListener('mousemove', onMove);
}

function onMove(e) {
    e.preventDefault();
    lastX = startX - e.clientX;
    lastY = startY - e.clientY;

    startX = e.clientX;
    startY = e.clientY;

    wrap.style.top = `${wrap.offsetTop - lastY}px`;
    wrap.style.left = `${wrap.offsetLeft - lastX}px`;
}