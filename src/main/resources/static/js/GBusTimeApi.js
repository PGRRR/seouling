var xhr = new XMLHttpRequest();
var url = 'http://apis.data.go.kr/6410000/busarrivalservice/getBusArrivalList'; /*URL*/
var queryParams = '?' + encodeURIComponent('serviceKey') + '='+'pYR6Y3Q/eSHYdkHNUYBvZkrl6CgXo57zIa/nrSwJ1XNhq4ypcWfhVcn6yMVMkthsm3Z7m7HYQi9VKD2Ul2vCvg=='; /*Service Key*/
queryParams += '&' + encodeURIComponent('stationId') + '=' + encodeURIComponent('200000078'); /**/
xhr.open('GET', url + queryParams);
xhr.onreadystatechange = function () {
    if (this.readyState == 4) {
        alert('Status: '+this.status+'nHeaders: '+JSON.stringify(this.getAllResponseHeaders())+'nBody: '+this.responseText);
    }
};

xhr.send('');