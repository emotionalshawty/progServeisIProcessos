# Servidor i Client Multicast de Paraules

## Descripció

Aquest projecte implementa un sistema de comunicació multicast amb:

1. **ServidorParaules.java**: Un servidor multicast que emet paraules aleatòries d'una llista pre-fabricada.
2. **ClientParaules.java**: Un client que es subscriu al servei multicast i compta les vegades que apareix cada paraula.

## Característiques

### Servidor (ServidorParaules)
- Emet paraules aleatòries cada segon
- Utilitza una llista de 12 paraules relacionades amb programació de xarxes
- Utilitza el protocol UDP amb multicast (IP: 224.0.12.112, Port: 5558)

### Client (ClientParaules)
- Es subscriu al grup multicast del servidor
- Mostra cada paraula rebuda amb el comptador actualitzat
- Al finalitzar, mostra un resum amb:
  - Totes les paraules rebudes
  - Número de vegades que ha aparegut cada paraula
  - Percentatge de cada paraula sobre el total
  - Total de paraules rebudes
- Timeout de 10 segons si no rep dades

## Com executar

### 1. Executar el Servidor
```bash
java nf2.multicast.exemple.ServidorParaules
```

### 2. Executar el Client (en una altra terminal)
```bash
java nf2.multicast.exemple.ClientParaules
```

Podeu executar múltiples clients alhora per veure com tots reben les mateixes paraules.

## Paraules de la llista

- Java
- Multicast
- Socket
- Thread
- Network
- Client
- Servidor
- Programació
- Concurrent
- Protocol
- UDP
- Datagram

## Exemple de sortida del Client

```
═══════════════════════════════════════════════════
Connectat a /224.0.12.112:5558
Escoltant paraules...
═══════════════════════════════════════════════════

➤ Rebuda: Java            | Vegades: 1
➤ Rebuda: Multicast       | Vegades: 1
➤ Rebuda: Thread          | Vegades: 1
➤ Rebuda: Java            | Vegades: 2
➤ Rebuda: Network         | Vegades: 1
...

═══════════════════════════════════════════════════
           RESUM DE PARAULES REBUDES
═══════════════════════════════════════════════════
  Java            |   5 vegades |  15.6%
  Thread          |   4 vegades |  12.5%
  Multicast       |   3 vegades |   9.4%
  ...
───────────────────────────────────────────────────
  TOTAL: 32 paraules rebudes
═══════════════════════════════════════════════════
```

## Notes tècniques

- **Protocol**: UDP (User Datagram Protocol)
- **Tipus**: Multicast
- **IP Multicast**: 224.0.12.112
- **Port**: 5558
- **Freqüència d'enviament**: 1 paraula per segon
- **Timeout del client**: 10 segons

