let a = document.querySelectorAll(".wrapper-problem-response .choicegroup_correct")
let b = document.querySelectorAll(".wrapper-problem-response .choicegroup_correct input")

for (let i = 0; i < a.length; i++) {
    a[i].classList.remove("choicegroup_correct")
    b[i].checked = false
}