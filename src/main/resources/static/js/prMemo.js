window.onload= function() {
    const btn = document.getElementById("memoBtn");
    btn.addEventListener('click',sendit);
}
function sendit() {
    const prMemo = document.getElementById("prMemo");
    const prIdx = document.getElementById("prIdx");


    if(prMemo.value == '') {
        alert("관리자 메모를 입력해주세요!");
        prMemo.focus();
        return false;
    }

    const api = "http://localhost:8888/api/user/memo";
    fetch(api, {
        method: "POST",
        headers: {'Content-Type': 'application/json'},
        body: JSON.stringify({
            "transaction_time": `${new Date()}`,
            "resultCode": "ok",
            "description": "정상",
            "data": {
                "prIdx": `${prIdx.value}`,
                "prMemo": `${prMemo.value}`
            }
        }),
    })
        .then((res) => {
            alert('메모등록 성공!')
            location.href='/user';
        })
        .then((data) => {
            console.log(data);
            return;
        })
        .catch((err) => {
            alert('다시확인해주세요!');
            location.reload();
            return;
        });

}