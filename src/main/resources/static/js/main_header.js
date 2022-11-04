
const mainMenu = document.querySelector(".main-menu");
const headerBot = document.querySelector(".header-bot");

mainMenu.onmouseover = () => {
    headerBot.classList.remove("invisible");
}

mainMenu.onmouseout = () => {
    headerBot.classList.add("invisible");
}