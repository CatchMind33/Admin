window.onload = function () {
    const btn = document.getElementById('registRestBtn');
    btn.addEventListener('click', sendit);
}

// 등록과 동시에 삭제
function deleteit() {
    const penBisName = document.getElementById('resa_bis_name').innerText;
    fetch(`http://localhost:7070/api/pending/delete`, {

        method: 'POST',
        headers: {'Content-Type': 'application/json'},
        body: JSON.stringify({
            "transaction_time": `${new Date()}`,
            "resultCode": "ok",
            "description": "정상",
            "data": {
                "penBisName": `${penBisName}`
            }
        }),
    })
        .then((res) => {
            return;
        })
        .then((data) => {
            console.log(data);
            return;
        })
        .catch((err) => {
            alert('에러!!');
            location.reload();
            return;
        });

}

function Bistro() {
    const bistroName = document.getElementById('resa_bis_name').innerText;
    fetch(`http://localhost:7070/api/restAdmin/bistro`, {

        method: 'POST',
        headers: {'Content-Type': 'application/json'},
        body: JSON.stringify({
            "transaction_time": `${new Date()}`,
            "resultCode": "ok",
            "description": "정상",
            "data": {
                "resaBisName": `${bistroName}`
            }
        }),
    })
        .then((res) => {
            return;
        })
        .then((data) => {
            console.log(data);
            return;
        })
        .catch((err) => {
            alert('에러!!');
            location.reload();
            return;
        });


}

function BisDetail() {
    const detailName = document.getElementById('resa_bis_name').innerText;
    fetch(`http://localhost:7070/api/restAdmin/detail`, {

        method: 'POST',
        headers: {'Content-Type': 'application/json'},
        body: JSON.stringify({
            "transaction_time": `${new Date()}`,
            "resultCode": "ok",
            "description": "정상",
            "data": {
                "resaBisName": `${detailName}`
            }
        }),
    })
        .then((res) => {
            return;
        })
        .then((data) => {
            console.log(data);
            return;
        })
        .catch((err) => {
            alert('에러!!');
            location.reload();
            return;
        });

}

function reserve() {
    const res_bis_name = document.getElementById('resa_bis_name').innerText;
    fetch(`http://localhost:7070/api/restAdmin/res`, {

        method: 'POST',
        headers: {'Content-Type': 'application/json'},
        body: JSON.stringify({
            "transaction_time": `${new Date()}`,
            "resultCode": "ok",
            "description": "정상",
            "data": {
                "resaBisName": `${res_bis_name}`
            }
        }),
    })
        .then((res) => {
            return;
        })
        .then((data) => {
            console.log(data);
            return;
        })
        .catch((err) => {
            alert('에러!!');
            location.reload();
            return;
        });
}

function total() {
    const total_bis_name = document.getElementById('resa_bis_name').innerText;
    fetch(`http://localhost:7070/api/restAdmin/total`, {

        method: 'POST',
        headers: {'Content-Type': 'application/json'},
        body: JSON.stringify({
            "transaction_time": `${new Date()}`,
            "resultCode": "ok",
            "description": "정상",
            "data": {
                "resaBisName": `${total_bis_name}`
            }
        }),
    })
        .then((res) => {
            return;
        })
        .then((data) => {
            console.log(data);
            return;
        })
        .catch((err) => {
            alert('에러!!');
            location.reload();
            return;
        });
}


function sendit() {
    const resaBisName = document.getElementById('resa_bis_name').innerText;
    const resaUserid = document.getElementById('resa_userid');
    const resaUserpw = document.getElementById('resa_userpw');
    const resaName = document.getElementById('resa_name');
    const resaHp = document.getElementById("resa_hp");
    const resaRegion = document.getElementById("resa_region");

    if (resaUserid.value == '') {
        alert('발급해줄 아이디를 입력하세요');
        resaUserid.focus()
        return false;
    }

    fetch('http://localhost:7070/api/restAdmin', {
        method: 'POST',
        headers: {'Content-Type': 'application/json'},
        body: JSON.stringify({
            "transaction_time": `${new Date()}`,
            "resultCode": "ok",
            "description": "정상",
            "data": {
                "resaUserid": `${resaUserid.value}`,
                "resaUserpw": `${resaUserpw.value}`,
                "resaName": `${resaName.value}`,
                "resaBisName": `${resaBisName}`,
                "resaHp": `${resaHp.value}`,
                "resaRegion": `${resaRegion.value}`
            }
        }),
    })
        .then((res)=> {
            Bistro();
            reserve();
            total();
        })
        .then((res)=> {
            BisDetail();
        })
        .then((res) => {
            deleteit();
            alert('등록성공')
            location.href = '/owner';
        })
        .then((data) => {
            console.log(data);
            return;
        })
        .catch((err) => {
            alert('에러!!');
            location.reload();
            return;
        });
}

