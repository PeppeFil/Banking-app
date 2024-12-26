document.addEventListener("DOMContentLoaded", function() {

    // Crea un nuovo conto
    document.getElementById('createAccountForm').addEventListener('submit', function(event) {
        event.preventDefault();
        
        const name = document.getElementById('name').value;
        const saldo = document.getElementById('saldo').value;

        // Costruisce l'URL con i parametri di query
        const url = `/api/accounts?nome=${encodeURIComponent(name)}&saldo=${encodeURIComponent(saldo)}`;

        fetch(url, {
            method: 'POST'
        })
        .then(response => {
            if (!response.ok) {
                throw new Error(`Errore nella risposta del server: ${response.status}`);
            }
            return response.json();
        })
        .then(data => {
            alert('Conto creato con successo! ID: ' + data.id);
        })
        .catch(error => console.error('Errore nella creazione del conto:', error));
    });

    // Visualizza saldo
    document.getElementById('viewBalanceForm').addEventListener('submit', function(event) {
        event.preventDefault();
        
        const accountId = document.getElementById('accountId').value;

        fetch(`/api/accounts/${accountId}`)
        .then(response => response.json())
        .then(data => {
            document.getElementById('balanceDisplay').textContent = `Saldo attuale: ${data.saldo}`;
        })
        .catch(error => console.error('Errore nel recupero del saldo:', error));
    });

    // Effettua un deposito
    document.getElementById('depositForm').addEventListener('submit', function(event) {
        event.preventDefault();
        
        const accountId = document.getElementById('depositAccountId').value;
        const amount = document.getElementById('depositAmount').value;

        fetch(`/api/accounts/${accountId}/deposito?importo=${encodeURIComponent(amount)}`, {
            method: 'PUT'
        })
        .then(response => response.json())
        .then(data => {
            alert('Deposito effettuato. Nuovo saldo: ' + data.saldo);
        })
        .catch(error => console.error('Errore nel deposito:', error));
    });

    // Effettua un prelievo
    document.getElementById('withdrawForm').addEventListener('submit', function(event) {
        event.preventDefault();
        
        const accountId = document.getElementById('withdrawAccountId').value;
        const amount = document.getElementById('withdrawAmount').value;

        fetch(`/api/accounts/${accountId}/prelievo?importo=${encodeURIComponent(amount)}`, {
            method: 'PUT'
        })
        .then(response => response.json())
        .then(data => {
            alert('Prelievo effettuato. Nuovo saldo: ' + data.saldo);
        })
        .catch(error => console.error('Errore nel prelievo:', error));
    });
});
