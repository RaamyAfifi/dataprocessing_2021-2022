let requestAnimeEpisode = new XMLHttpRequest()

requestAnimeEpisode.open('GET', 'http://localhost:8080/animes/', true)
requestAnimeEpisode.onload = function ()
{
    // Begin accessing JSON data here
    data = JSON.parse(this.response)

    if (requestAnimeEpisode.status >= 200 && requestAnimeEpisode.status < 400)
    {
        let labels = [];
        let graphData = [];
        data.forEach(data => {
            console.log(data.title);
            labels.push(data.title);
            graphData.push(data.episodes);
        });

        let ctx = document.getElementById("graph")
        let myChart = new Chart(ctx, {
            type: 'doughnut',
            data: {
                labels: labels,
                datasets: [{
                    label: 'Anime',
                    data: graphData,
                    backgroundColor: [
                        'rgba(151, 8, 8, 0.6)',
                        'rgba(0, 200, 6, 0.6)',
                        'rgba(0, 0, 200, 0.6)',
                        'rgba(0, 200, 200, 0.6)',
                        'rgba(200, 0, 200, 0.6)'

                    ],
                    borderColor: [
                        'rgba(151, 8, 8, 1)'
                    ],
                    borderWidth: 1
                }]
            },
            options: {
                responsive: true,
                plugins: {
                    legend: {
                        position: 'top',
                    },
                    title: {
                        display: true,
                        text: 'Anime Data'
                    }
                }
            }
        });
    }
    else
    {
        console.log('error')
    }
}
requestAnimeEpisode.send();

let requestAnime = new XMLHttpRequest()

requestAnime.open('GET', 'http://localhost:8080/reviews/', true)
requestAnime.onload = function ()
{
    // Begin accessing JSON data here
    data = JSON.parse(this.response)

    if (requestAnime.status >= 200 && requestAnime.status < 400)
    {
        let labels = [];
        let graphData = [];
        data.forEach(data => {
            console.log(data.uid);
            labels.push(data.uid);
            graphData.push(data.score);
        });

        let ctx = document.getElementById("graph2")
        let myChart = new Chart(ctx, {
            type: 'line',
            data: {
                labels: labels,
                datasets: [{
                    fill: false,
                    label: 'Anime',
                    data: graphData,
                    backgroundColor: [
                        'rgba(151, 8, 8, 0.6)',

                    ],
                    borderColor: [
                        'rgba(151, 8, 8, 1)'
                    ],
                    // borderWidth: 1
                }]
            },
            options: {
                scales: {
                    yAxes: [{
                        scaleLabel: {
                            display: true,
                            labelString: 'Rating',

                        },
                        ticks: {
                            beginAtZero: true
                        }
                    }],
                    xAxes: [{
                        scaleLabel: {
                            display: true,
                            labelString: 'Anime UID'
                        }
                    }]
                },
                responsive: true,
                plugins: {
                    legend: {
                        position: 'top',
                    },
                    title: {
                        display: true,
                        text: 'Anime Data'
                    }
                }
            }
        });
    }
    else
    {
        console.log('error')
    }
}
requestAnime.send();

let requestProfileGender = new XMLHttpRequest()

requestProfileGender.open('GET', 'http://localhost:8080/profiles/', true)
requestProfileGender.onload = function ()
{

    // Begin accessing JSON data here
    data = JSON.parse(this.response)

    if (requestProfileGender.status >= 200 && requestProfileGender.status < 400)
    {
        let labels = [];
        let graphData = [];
        let man = 0;
        let woman = 0;
        let neutral = 0;
        data.forEach(data => {

            if(data.gender == "Man"){
                man++;
            }else if(data.gender == "Women"){
                woman++
            }else if(data.gender == "Neutral"){
                neutral++
            }
            console.log(data.gender);

        });
        labels.push("Man", "Woman", "Neutral");
        graphData.push(man, woman, neutral);
        let ctx = document.getElementById("graph3")
        let myChart = new Chart(ctx, {
            type: 'doughnut',
            data: {
                labels: labels,
                datasets: [{
                    label: 'Anime',
                    data: graphData,
                    backgroundColor: [
                        'rgba(151, 8, 8, 0.6)',
                        'rgba(0, 200, 6, 0.6)',
                        'rgba(0, 0, 200, 0.6)',

                    ],
                    borderColor: [
                        'rgba(151, 8, 8, 1)'
                    ],
                    borderWidth: 1
                }]
            },
            options: {
                responsive: true,
                plugins: {
                    legend: {
                        position: 'top',
                    },
                    title: {
                        display: true,
                        text: 'Anime Data'
                    }
                }
            }
        });
    }
    else
    {
        console.log('error')
    }
}
requestProfileGender.send();

let requestProfileYear = new XMLHttpRequest()

requestProfileYear.open('GET', 'http://localhost:8080/profiles/', true)
requestProfileYear.onload = function ()
{

    // Begin accessing JSON data here
    data = JSON.parse(this.response)

    if (requestProfileYear.status >= 200 && requestProfileYear.status < 400)
    {
        let labels = [];
        let graphData = [];
        let year = 2000;
        let countMore = 0;
        let countLess = 0;
        data.forEach(data => {
            let splittedData = data.birthday.split(',');
            let firstPart = splittedData[0];
            let secondPart = splittedData[1];
            let parsedData = parseInt(secondPart);

            if(parsedData < year){
                countLess++;
            }else if(parsedData >= year) {
                countMore++;
            }

            console.log(data.birthday);

        });
        labels.push("Born before 2000", "Born after 2000");
        console.log(countLess + " hierzo");
        console.log(countMore + "countmore");
        graphData.push(countLess, countMore);
        let ctx = document.getElementById("graph4")
        let myChart = new Chart(ctx, {
            type: 'bar',
            data: {
                labels: labels,
                datasets: [{
                    label: 'Anime',
                    data: graphData,
                    backgroundColor: [
                        'rgba(151, 8, 8, 0.6)',
                        'rgba(0, 200, 6, 0.6)',

                    ],
                    borderColor: [
                        'rgba(151, 8, 8, 1)'
                    ],
                    borderWidth: 1
                }]
            },
            options: {
                scales: {
                    yAxes: [{
                        scaleLabel: {
                            display: true,
                            labelString: 'Amount of profiles',
                        },
                        ticks:{
                            beginAtZero: true
                        }
                    }],
                    xAxes: [{
                        scaleLabel: {
                            display: true,
                            labelString: 'Born ratio'
                        },

                    }]
                },
                responsive: true,
                plugins: {
                    legend: {
                        position: 'top',
                    },
                    title: {
                        display: true,
                        text: 'Anime Data'
                    },

                }
            }
        });
    }
    else
    {
        console.log('error')
    }
}
requestProfileYear.send();