# Resum de Canvis i Correccions

## ✅ Correcció de SrvVelocitats.java

### Problemes trobats i solucionats:

1. **ERROR CRÍTIC**: El nom del fitxer no coincidia amb el nom de la classe
   - Fitxer: `Srvvelocitats.java` 
   - Classe: `SrvVelocitats`
   - **Solució**: Renombrat el fitxer a `SrvVelocitats.java`

2. **ERROR**: Gestió incorrecta de l'excepció InterruptedException
   - Problema: `ex.getMessage()` sense fer res amb el resultat
   - **Solució**: 
     - Afegit `System.err.println("Error: " + ex.getMessage());`
     - Afegit `Thread.currentThread().interrupt();` per preservar l'estat d'interrupció

### Estat final:
- ✅ Compila sense errors
- ✅ Gestió correcta d'excepcions
- ⚠️ Només queda una advertència de "busy-waiting" que és acceptable

---

## 📦 Nous fitxers creats per la tasca de Multicast

### 1. ServidorParaules.java
**Ubicació**: `src\nf2\multicast\exemple\ServidorParaules.java`

**Funcionalitat**:
- Servidor multicast que emet paraules aleatòries
- Llista de 12 paraules relacionades amb programació de xarxes
- Envia una paraula cada segon
- IP Multicast: 224.0.12.112
- Port: 5558

**Característiques**:
- Protocol UDP
- Enviament periòdic (cada 1 segon)
- Llista pre-fabricada de paraules

### 2. ClientParaules.java
**Ubicació**: `src\nf2\multicast\exemple\ClientParaules.java`

**Funcionalitat**:
- Client que es subscriu al grup multicast
- Compta les vegades que apareix cada paraula
- Mostra comptadors en temps real
- Mostra resum final amb:
  - Paraules rebudes
  - Número de vegades
  - Percentatge sobre el total
  - Total de paraules

**Característiques**:
- Utilitza HashMap per comptar paraules
- Timeout de 10 segons
- Presentació formatada amb Unicode
- Resum ordenat per freqüència

### 3. Scripts d'execució (.bat)
- `executar_servidor.bat` - Llança el servidor de paraules
- `executar_client.bat` - Llança el client de paraules

### 4. Documentació
- `README_PARAULES.md` - Documentació completa del projecte

---

## 🚀 Com utilitzar-ho

### Opció 1: Amb els scripts batch
1. Fes doble clic a `executar_servidor.bat`
2. En una altra finestra, fes doble clic a `executar_client.bat`
3. Pots obrir múltiples clients per veure com tots reben les mateixes paraules

### Opció 2: Des de la terminal
```powershell
# Terminal 1 - Servidor
cd C:\Users\alum-01\IdeaProjects\progServeisIProcessos\src
java nf2.multicast.exemple.ServidorParaules

# Terminal 2 - Client
cd C:\Users\alum-01\IdeaProjects\progServeisIProcessos\src
java nf2.multicast.exemple.ClientParaules
```

### Opció 3: Des de IntelliJ IDEA
1. Obre `ServidorParaules.java` i executa el main
2. Obre `ClientParaules.java` en un altre procés i executa el main

---

## 📊 Exemple de sortida

### Servidor:
```
Servidor de paraules iniciat a /224.0.12.112:5558
Enviant paraules aleatòries...

Enviada: Java
Enviada: Multicast
Enviada: Thread
...
```

### Client:
```
═══════════════════════════════════════════════════
Connectat a /224.0.12.112:5558
Escoltant paraules...
═══════════════════════════════════════════════════

➤ Rebuda: Java            | Vegades: 1
➤ Rebuda: Multicast       | Vegades: 1
➤ Rebuda: Thread          | Vegades: 1
➤ Rebuda: Java            | Vegades: 2
...

═══════════════════════════════════════════════════
           RESUM DE PARAULES REBUDES
═══════════════════════════════════════════════════
  Java            |   5 vegades |  15.6%
  Thread          |   4 vegades |  12.5%
  Multicast       |   3 vegades |   9.4%
───────────────────────────────────────────────────
  TOTAL: 32 paraules rebudes
═══════════════════════════════════════════════════
```

---

## 📝 Notes tècniques

- **Protocol**: UDP (User Datagram Protocol)
- **Tipus de connexió**: Multicast
- **Codificació**: UTF-8 per suportar caràcters catalans
- **Gestió d'errors**: Timeouts i excepcions correctament gestionades
- **Compilació**: Verificada i sense errors

---

## 🎯 Objectius aconseguits

✅ Servidor multicast funcional que emet paraules aleatòries  
✅ Client que es subscriu i compta les paraules rebudes  
✅ Visualització en temps real dels comptadors  
✅ Resum final amb estadístiques  
✅ Correcció dels errors de SrvVelocitats.java  
✅ Scripts d'execució per facilitar l'ús  
✅ Documentació completa  

