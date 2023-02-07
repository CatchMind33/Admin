window.onload = function () {
    const btn = document.getElementById('registRestBtn');
    btn.addEventListener('click', sendit);
}

let resaBisName = document.getElementById('resa_bis_name').innerText;

function BisDetail() {
    fetch(`http://localhost:7070/api/restAdmin/detail`, {

        method: 'POST',
        headers: {'Content-Type': 'application/json'},
        body: JSON.stringify({
            "transaction_time": `${new Date()}`,
            "resultCode": "ok",
            "description": "정상",
            "data": {
                "resaBisName": `${resaBisName}`
            }
        }),
    })
        .then((res) => {

        })
        .then((data) => {
            console.log(data);

        })
        .catch((err) => {
            alert('에러!!');
            location.reload();

        });

}

// 식당 정원 테이블에 넣는 로직
function total() {
    fetch(`http://localhost:7070/api/restAdmin/total`, {

        method: 'POST',
        headers: {'Content-Type': 'application/json'},
        body: JSON.stringify({
            "transaction_time": `${new Date()}`,
            "resultCode": "ok",
            "description": "정상",
            "data": {
                "resaBisName": `${resaBisName}`
            }
        }),
    })
        .then((res) => {

        })
        .then((data) => {
            console.log(data);

        })
        .catch((err) => {
            alert('에러!!');
            location.reload();

        });
}

// 편의시설 테이블에 식당이름 등록
function fac() {
    fetch(`http://localhost:7070/api/restAdmin/fac`, {

        method: 'POST',
        headers: {'Content-Type': 'application/json'},
        body: JSON.stringify({
            "transaction_time": `${new Date()}`,
            "resultCode": "ok",
            "description": "정상",
            "data": {
                "resaBisName": `${resaBisName}`
            }
        }),
    })
        .then((res) => {

        })
        .then((data) => {
            console.log(data);

        })
        .catch((err) => {
            alert('에러!!');
            location.reload();

        });

}

// 사진테이블에 식당이름 등록
function photo() {
    fetch(`http://localhost:7070/api/restAdmin/photo`, {

        method: 'POST',
        headers: {'Content-Type': 'application/json'},
        body: JSON.stringify({
            "transaction_time": `${new Date()}`,
            "resultCode": "ok",
            "description": "정상",
            "data": {
                "resaBisName": `${resaBisName}`
            }
        }),
    })
        .then((res) => {

        })
        .then((data) => {
            console.log(data);

        })
        .catch((err) => {
            alert('에러!!');
            location.reload();

        });

}


// 등록과 동시에 삭제
function deleteit() {
    fetch(`http://localhost:7070/api/pending/delete`, {

        method: 'POST',
        headers: {'Content-Type': 'application/json'},
        body: JSON.stringify({
            "transaction_time": `${new Date()}`,
            "resultCode": "ok",
            "description": "정상",
            "data": {
                "penBisName": `${resaBisName}`
            }
        }),
    })
        .then((res) => {

        })
        .then((data) => {
            console.log(data);

        })
        .catch((err) => {
            alert('에러!!');
            location.reload();

        });

}

// 식당정보에 식당이름 등록 로직
function Bistro() {
    fetch(`http://localhost:7070/api/restAdmin/bistro`, {

        method: 'POST',
        headers: {'Content-Type': 'application/json'},
        body: JSON.stringify({
            "transaction_time": `${new Date()}`,
            "resultCode": "ok",
            "description": "정상",
            "data": {
                "resaBisName": `${resaBisName}`
            }
        }),
    })
        .then((res) => {

        })
        .then((data) => {
            console.log(data);

        })
        .catch((err) => {
            alert('에러!!');
            location.reload();

        });


}

// 식당 상세정보에 이름 및 식당 정보 등록 로직


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
        .then((res) => {
            resaBis();
        })
        .then((res) => {
            deleteit();
            alert('등록성공')
            location.href = '/owner';
        })
        .then((data) => {
            console.log(data);

        })
        .catch((err) => {
            alert('에러!!');
            location.reload();

        });
}
const resaBis = async () => {
    await Bistro()
    await total()
    await photo()
    await fac()
    await BisDetail()
}



