window.onload = function (){
    const btn = document.getElementById('registRestBtn');
    btn.addEventListener('click',sendit);
}

function deleteit(){
    const penBisName = document.getElementById('resa_bis_name').innerText;
    fetch(`http://localhost:8888/api/pending/delete`, {

        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify({
            "transaction_time":`${new Date()}`,
            "resultCode":"ok",
            "description":"정상",
            "data":{
                "penBisName":`${penBisName}`
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


function sendit(){
    const resaBisName = document.getElementById('resa_bis_name').innerText;
    const resaUserid = document.getElementById('resa_userid');
    const resaUserpw = document.getElementById('resa_userpw');
    const resaName = document.getElementById('resa_name');
    const resaHp = document.getElementById("resa_hp");
    const resaRegion = document.getElementById("resa_region");

    if(resaUserid.value==''){
        alert('발급해줄 아이디를 입력하세요');
        resaUserid.focus()
        return false;
    }

    //fetch
    fetch('http://localhost:8888/api/restAdmin', {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify({
            "transaction_time":`${new Date()}`,
            "resultCode":"ok",
            "description":"정상",
            "data":{
                "resaUserid":`${resaUserid.value}`,
                "resaUserpw":`${resaUserpw.value}`,
                "resaName":`${resaName.value}`,
                "resaBisName":`${resaBisName}`,
                "resaHp":`${resaHp.value}`,
                "resaRegion":`${resaRegion.value}`
            }
        }),
    })
        .then((res) => {
            alert('등록성공')
            deleteit();
            location.href='/owner';
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