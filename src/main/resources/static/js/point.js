window.onload = function(){
    const btn = document.getElementById('point_btn');
    btn.addEventListener('click', sendPoint);
}

function updateTotPoint(){
    const poNick = document.getElementById('pr_nick').innerText;
    const poList = document.getElementById('point');

    fetch('http://localhost:7070/api/user/updatePoint', {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify({
            "transaction_time":`${new Date()}`,
            "resultCode":"ok",
            "description":"정상",
            "data":{
                "prNick":`${poNick}`,
                "prPoint":`${poList.value}`,
            }
        }),
    })
        .then((res) => {
            return;
        })

        .catch((err) => {
            alert('에러!!');
            location.reload();
            return;
        });
}

function sendPoint(){
    const poNick = document.getElementById('pr_nick').innerText;
    const poList = document.getElementById('point');
    const poMessage = document.getElementById('message');



    fetch('http://localhost:8888/api/point', {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify({
            "transaction_time":`${new Date()}`,
            "resultCode":"ok",
            "description":"정상",
            "data":{
                "poNick":`${poNick}`,
                "poList":`${poList.value}`,
                "poMessage":`${poMessage.value}`
            }
        }),
    })
        .then((res) => {
            alert('포인트 등록완료!')
            updateTotPoint()
            location.href='/user'
            return;
        })

        .catch((err) => {
            alert('에러!!');
            location.reload();
            return;
        });
}