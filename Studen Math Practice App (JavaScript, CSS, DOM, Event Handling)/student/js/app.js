let correctAnswer;
let points = 0;
let currentProblemNum = 1;


/**
* Utility function to shuffle the items in an array
* @param {object} arr
*/
function shuffleArray(arr) {
    return arr.sort(function (a, b) { return Math.random() - 0.5 })
}


/**
* Utility function to generate a random number based on max
* @param {number} max
*/
function getRandomNumber(max) {
    return Math.floor(Math.random() * Math.floor(max));
}


//Create function that take in 'click' event
function answerCorrect() {
    const liAnswer = document.querySelector('li')
    liAnswer.innerText === correctAnswer;
}



function populateQuestionAndAnswer() {

    let leftNumber = getRandomNumber(10)
    let rightNumber = getRandomNumber(10)
    correctAnswer = leftNumber * rightNumber;


    let strLeftNum = leftNumber.toString();
    let strRightNum = rightNumber.toString();

    let currentLi = document.querySelector('.currentProblem')
    let newLi = parseInt(currentLi.innerText)

    let showExpression = document.getElementById('problem');
    showExpression.querySelector('div.expression').innerText = leftNumber + ' * ' + rightNumber;


    let randomAnswerA = getRandomNumber(100)
    while (randomAnswerA === correctAnswer) {
        randomAnswerA = getRandomNumber(100)
    }

    let randomAnswerB = getRandomNumber(100)
    while (randomAnswerB === correctAnswer) {
        randomAnswerB = getRandomNumber(100)
    }

    let randomAnswerC = getRandomNumber(100)
    while (randomAnswerC === correctAnswer) {
        randomAnswerC = getRandomNumber(100)
    }


    let arrayNumbers = [correctAnswer, randomAnswerA, randomAnswerB, randomAnswerC]

    shuffleArray(arrayNumbers)


    let listOfAnswers = document.getElementById('answers');
    let ul = document.querySelector('ul');
    arrayNumbers.forEach((num) => {
        document.querySelector('li').innerText = num;
        const li = document.querySelector('li');
        ul.appendChild(li);
    })


}




document.addEventListener("DOMContentLoaded", () => {

    //THIS IS FOR WHEN THE USER WANT TO START OVER THE QUIZ
    const startOver = document.querySelectorAll('#btnStartOver')
    startOver.forEach((over) => {
        over.addEventListener('click',() => {

            points = 0;
            currentProblemNum = 1;
            populateQuestionAndAnswer();

            //show the possible answers again (this is for when after the user is done with answering 10 questions)
            document.getElementById('answers').style.display = ''; 
            document.querySelector('.expression').style.display = '';
            document.querySelector('.show-hide').style.display = '';

            const currentScore = document.querySelector('.currentScore')
            currentScore.innerText = 0

            const currentProblem = document.querySelector('.currentProblem')
            currentProblem.innerText = 1

        })
    })

    populateQuestionAndAnswer(); ////populate question and answers the first time

    const lists = document.querySelectorAll('li');

    //let points = 0;
    //let currentProblemNum = 2;

    lists.forEach((list) => {

        list.addEventListener('click', () => {

            currentProblemNum++ //increment and move to the next question 

            if (currentProblemNum <= 11) {
                if (parseInt(list.innerText) === correctAnswer) {

                    points++
                    const currentScore = document.querySelector('.currentScore')
                    currentScore.innerText = points

                }

                const currentProblem = document.querySelector('.currentProblem')

                if(currentProblemNum<11){
                    currentProblem.innerText = currentProblemNum;
                }
            
                populateQuestionAndAnswer(); //Keep populating the questions & answers 9 more times (for a total of 10 questions)

            }
            
            if (currentProblemNum === 11){
                document.getElementById('answers').style.display = 'none';
                document.querySelector('.expression').style.display = 'none';
                document.querySelector('.show-hide').style.display = 'none';

            }

        })

    })

    //***FOR TESTING ONLY - PRINT OUTS */
    //console.log(leftNumber + ' * ' + rightNumber + ' = ' + correctAnswer)
    //console.log('array: ' + arrayNumbers)

});



