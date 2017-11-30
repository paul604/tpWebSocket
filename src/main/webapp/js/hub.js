Chat = function(url){
    this.url = url;
    
    if (this.webSocket !== undefined
            && this.webSocket.readyState !== WebSocket.CLOSED) {
        console.log("WebSocket is already opened.");
    } else {

        this.webSocket = new WebSocket(this.url);
    }
    /**
     * Binds functions to the listeners for the websocket.
     */
    this.webSocket.onopen = function(event){
        console.log("web socket open at "+ this.url);
    };

    this.webSocket.onmessage = function(event) {
        console.log(event.data);
    };

    this.webSocket.onclose = function(event) {
        if(event.code != 1006 && event.code > 1001){
            console.log(evet);
            console.log("code "+ event.code);
            showLostConnection();
            console.log("connection closed");
        }

        if(event.code == 1006){
            console.log("abnormal closing websocket : reload page");
            location.reload(true);
        }
    };

    this.send = function(message) {
    	this.webSocket.send(message);
    }
}
