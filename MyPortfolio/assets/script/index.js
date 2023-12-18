let greetMe = "안녕하세요.\n 잘 부탁드립니다.";
let index = 0;
let $text = document.querySelector(".main-profile-msg")

let typingAction = function () {
    $text.innerHTML += greetMe[index++];
    if (greetMe[index] == "\n") {
        $text.innerHTML += "<br />";
    }
    if ($text.textContent.length > greetMe.length) {
        $text.innerHTML = "";
        index = 0;
    }
};

setInterval(typingAction, 200);