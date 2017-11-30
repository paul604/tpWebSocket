Chat = function(url){
    this.url = url;

    this.webSocket = new WebSocket(this.url);

    this.webSocket.onopen = function(event){
        console.log("web socket open at "+ this.url);
    };

    this.webSocket.onmessage = function(event) {
        var data = JSON.parse(event.data);
        console.log(data);
    };

    this.webSocket.onclose = function(event) {
        if(event.code != 1006 && event.code > 1001){
            console.log(evet);
            console.log("code "+ event.code);
            showLostConnection();
            console.log("connection closed");
        }

        if(event.code == 1006){
            console.log("abnormal closeing websocket : reload page");
            location.reload(true);
        }
    };
}
