window.onload = function (){
    const btn = document.getElementById('loginBtn');
    btn.addEventListener('click',sendit);
}
function sendit(){

    const adUserid = document.getElementById('adUserid');
    const adUserpw = document.getElementById('adUserpw');

    if(adUserid.value==''){
        alert('아이디를 입력하세요');
        adUserid.focus()
        return false;
    }

    if(adUserpw.value==''){
        alert('비밀번호를 입력하세요');
        adUserpw.focus()
        return false;
    }

    document.getElementById('loginFrm').submit();
}