var xhr = new XMLHttpRequest();
var url = 'http://apis.data.go.kr/6410000/busrouteservice/getBusRouteInfoItem'; /*URL*/
var queryParams = '?' + encodeURIComponent('serviceKey') + '='+'pYR6Y3Q/eSHYdkHNUYBvZkrl6CgXo57zIa/nrSwJ1XNhq4ypcWfhVcn6yMVMkthsm3Z7m7HYQi9VKD2Ul2vCvg=='; /*Service Key*/
queryParams += '&' + encodeURIComponent('routeId') + '=' + encodeURIComponent('200000085'); /**/
xhr.open('GET', url + queryParams);
xhr.onreadystatechange = function () {
    if (this.readyState === 4) {
        alert('Status: '+this.status+'nHeaders: '+JSON.stringify(this.getAllResponseHeaders())+'nBody: '+this.responseText);
    }
};

xhr.send('');

let xmlParser = new DOMParser(); //DOM파서 객체를 생성
let xmlDoc = xmlParser.parseFromString(text, "text/xml"); // parseFromString() 메소드를 이용해 문자열을 파싱함.
let value = xmlDoc.getElementsByTagName("name")[0].textContent; console.log(value); // HTML