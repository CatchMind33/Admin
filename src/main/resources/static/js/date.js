const date = new Date();
const dateTag = document.querySelector('.date');
dateTag.innerHTML = date.toLocaleDateString('ko-kr');
