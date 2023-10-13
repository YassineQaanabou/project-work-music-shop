 function renderCharts(timeSelect) {
        console.log(timeSelect);
        //acqusiti
        fetch(`/admin/api/acquisti?time=${timeSelect}`)
          .then((response) => response.json())
          .then((data) => {
            // Estrai le etichette e i dati dai risultati
            const labels = data.map((item) => item[0]); // Nome del prodotto
            const dataValues = data.map((item) => item[1]); // Vendite totali

            // Crea il grafico a torta con Chart.js
            var ctx = document.getElementById("pieChart").getContext("2d");
            var pieChart = new Chart(ctx, {
              type: "pie",
              data: {
                labels: labels,
                datasets: [
                  {
                    data: dataValues,
                    backgroundColor: [
                      "rgba(255, 99, 132, 0.5)",
                      "rgba(54, 162, 235, 0.5)",
                      "rgba(255, 206, 86, 0.5)",
                      "rgba(75, 192, 192, 0.5)",
                      "rgba(153, 102, 255, 0.5)",
                      // Altri colori...
                    ],
                    borderWidth: 1,
                  },
                ],
              },
            });
          })
          .catch((error) => console.error(error));

        // acquisti profitto
        // Fetch data from the API `/admin/api/profitto?time=${timeSelect}`
        fetch(`/admin/api/profitto?time=${timeSelect}`)
          .then((response) => response.json())
          .then((data) => {
            // Format the dates to display only the day
            const labels = data.map((item) => {
              const date = new Date(item.data);
              const month = date.toLocaleString("default", { month: "long" }); // Get the month name
              const year = date.getFullYear();
              return `${month} ${year}`;
            });
            const profit = data.map((item) => item.profittoCumulativo);

            const ctx = document.getElementById("profitChart").getContext("2d");
            new Chart(ctx, {
              type: "line",
              data: {
                labels: labels,
                datasets: [
                  {
                    label: "Profitto",
                    data: profit,
                    borderColor: "rgba(75, 192, 192, 1)",
                    borderWidth: 2,
                    fill: false,
                  },
                ],
              },
              options: {
                scales: {
                  x: {
                    title: {
                      display: true,
                    },
                  },
                  y: {
                    beginAtZero: true,
                    title: {
                      display: true,
                      text: "Profitto ",
                    },
                  },
                },
              },
            });
          })
          .catch((error) => console.error(error));

        // fetch per tipologia
        // Fetch data from the REST controller endpoint
        fetch(`/admin/api/acquisti-per-tipologia?time=${timeSelect}`)
          .then((response) => response.json())
          .then((data) => {
            // Extract the labels and dataValues from the JSON data
            const labels = data.map((item) => item.nome);
            const dataValues = data.map((item) => item.quantity);

            // Get the canvas element and create a bar chart
            const ctx = document.getElementById("barChart").getContext("2d");
            const barChart = new Chart(ctx, {
              type: "bar",
              data: {
                labels: labels,
                datasets: [
                  {
                    label: "Quantità",
                    data: dataValues,
                    backgroundColor: [
                      "rgba(255, 99, 132, 0.5)",
                      "rgba(54, 162, 235, 0.5)",
                      "rgba(255, 206, 86, 0.5)",
                      "rgba(75, 192, 192, 0.5)",
                      // You can add more background colors if needed
                    ],
                    borderColor: [
                      "rgba(255, 99, 132, 1)",
                      "rgba(54, 162, 235, 1)",
                      "rgba(255, 206, 86, 1)",
                      "rgba(75, 192, 192, 1)",
                      // You can add more border colors if needed
                    ],
                    borderWidth: 1,
                  },
                ],
              },
              options: {
                scales: {
                  y: {
                    beginAtZero: true,
                    title: {
                      display: true,
                      text: "Quantità",
                    },
                  },
                },
              },
            });
          })
          .catch((error) => console.error(error));
      }
     
   
      var initialTimeSelect = document.getElementById("time").value;
   console.log(initialTimeSelect);
  renderCharts(initialTimeSelect);

  // Chiama renderCharts con il valore iniziale
 









