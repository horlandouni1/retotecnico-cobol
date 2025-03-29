Procesamiento de Transacciones Bancarias (CLI)
Aplicación Java para generar reportes de transacciones desde un archivo CSV
📌 Introducción
Esta aplicación procesa un archivo CSV con transacciones bancarias (Créditos/Débitos) y genera un reporte con:
✅ Balance final (Total Créditos - Total Débitos)
✅ Transacción de mayor monto (ID y valor)
✅ Conteo de transacciones por tipo

⚙️ Requisitos
Java JDK 11+
Git (opcional, para clonar el repositorio)

🚀 Instrucciones de Ejecución
1. Opción 1: Ejecutar con IntelliJ IDEA (Recomendado para desarrollo)
   1. Clona/descarga el proyecto.
   2. Abre IntelliJ IDEA → "Open" → Selecciona la carpeta del proyecto.
   3. Ejecuta Main.java con el argumento: src/main/resources/transactions.csv
      (Configuración: Run → Edit Configurations → Program Arguments)

2. Opción 2: Ejecutar desde terminal (sin IDE)
   Pasos para compilar y ejecutar:
   1. Descargar el proyecto: 
      git clone https://github.com/horlandouni1/retotecnico-cobol
      cd retotecnico-cobol
   2. Compilar el código: javac -d ./out ./src/main/java/org/example/*.java
   3. Ejecutar el programa:
      java -cp ./out org.example.Main ./src/main/resources/transactions.csv
3. Opción 3: Usar un archivo JAR (Para distribución fácil)
   Si tienes un JAR ejecutable:
   java -jar retotecnico-cobol.jar transactions.csv

📂 Estructura del Proyecto
retotecnico-cobol/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── org/example/
│   │   │       ├── Main.java            # Punto de entrada
│   │   │       ├── Transaction.java     # Modelo de transacción
│   │   │       ├── TransactionProcessor.java # Lógica de procesamiento
│   │   │       └── TransactionReport.java     # Modelo de reporte
│   │   └── resources/
│   │       └── transactions.csv        # Ejemplo de datos
└── README.md

📝 Formato del Archivo CSV
El archivo debe tener la estructura:
id,tipo,monto
1,Crédito,100.00
2,Débito,50.00
3,Crédito,200.00

📊 Ejemplo de Salida
Reporte de Transacciones
---------------------------------------------
Balance Final: 325.00
Transacción de Mayor Monto: ID 3 - 200.00
Conteo de Transacciones: Crédito: 3 Débito: 2

🔧 Solución Técnica
Lógica implementada
1. Lectura del CSV:
   - Usa BufferedReader para leer línea por línea.
   - Omite la cabecera y parsea los datos.

2. Procesamiento:
   - Calcula el balance final (Créditos - Débitos).
   - Identifica la transacción con mayor monto.
   - Cuenta transacciones por tipo.

3. Generación del reporte:
   - Formatea los resultados en consola.



