** Notes **

Si le polyfill pour IE et les CustomEvent est trop violent, il pourrait etre bon d'utiliser:

````
function createNewEvent(eventName) {
    if(typeof(Event) === 'function') {
        var event = new Event(eventName);
    }else{
        var event = document.createEvent('Event');
        event.initEvent(eventName, true, true);
    }
}
````