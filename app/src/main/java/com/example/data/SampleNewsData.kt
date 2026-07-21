package com.example.data

object SampleNewsData {
    val initialArticles = listOf(
        NewsArticle(
            id = "news_1",
            title = "Congreso debate moción de interpelación contra el Ministro de Economía por presupuesto 2024",
            source = "El Comercio",
            timeAgo = "Hace 2 horas",
            category = "Congreso",
            imageUrl = "https://lh3.googleusercontent.com/aida-public/AB6AXuC8rh_OCNAEjz72mZA9ppOMWxSOjJJZ_MTzoPBTwBkWrdiUgQEHF4GVyfFnLBTnu3WC_1nDWNFmou28dt1Xpg7Uj8xacRwE0im6UoBjBo1R70TfSxyWj6F6Tpi9i1Hgq4-97sp3vR5FIB1FYDW0wH9F-t72XCUQI9hI9dPHhz6wKn6V-mQnx9iJvLxyGIKaMNp6M3xSOKayJ4pFcFK-smAHtQ4QLLfFKKbeyWyZkkpZgPu4Z72r5zRMWATLottLX8qhdqkexJMVLHZ9",
            summary = "En el Pleno del Congreso de la República se dio inicio al debate para la interpelación del titular del Ministerio de Economía y Finanzas, en relación con la ejecución del gasto presupuestario y las proyecciones macroeconómicas para el presente año.",
            content = """
                Lima, Perú. - El Pleno del Congreso de la República comenzó hoy la discusión de la pliego interpelatorio dirigido al titular del Ministerio de Economía y Finanzas (MEF). Representantes de diversas bancadas expresaron sus inquietudes respecto al cumplimiento de las metas fiscales y el nivel de inversión pública asignado a los gobiernos regionales.

                Durante la sesión, el ministro sostuvo que las medidas aplicadas responden a un marco de prudencia fiscal destinado a contener las presiones inflacionarias y dinamizar el empleo formal. Asimismo, destacó que los recursos priorizados para infraestructura social superan el promedio de los últimos tres ejercicios fiscales.

                Sin embargo, legisladores de la oposición insistieron en solicitar aclaraciones detalladas sobre el déficit fiscal acumulado y las medidas adoptadas para impulsar a las micro y pequeñas empresas (MYPE) afectadas por desaceleraciones previas. La votación para definir los siguientes pasos parlamentarios continuará en las próximas horas.
            """.trimIndent(),
            isViral = true,
            isSaved = false
        ),
        NewsArticle(
            id = "news_2",
            title = "JNE ratifica calendario electoral para las próximas elecciones municipales complementarias",
            source = "RPP",
            timeAgo = "Hace 5 horas",
            category = "Electoral",
            imageUrl = "https://lh3.googleusercontent.com/aida-public/AB6AXuAqyQThgI28MfnOR26zzkCzZYVgVANSYrwyFk64OHuTZ2Lbq4duHMORlHWbdgmGsPYaG7vGbemyso7qiitzaWiB343u6zISAJT-Hii9liPYsQ6nKq71TmqpOb0W6S2U_DYow9kKByCrgGkeyyvhtKa_h0v3UE12rH5STSGceEJxrHK6Js_czPXNsMlWJFks9Daml5v6SY0T5lw_mUWmTh-niN-fL-J6GtJUVzdZa20irAGK8nbg0qjQBLsYgj7ppiBOl2ftH4Ansovh",
            summary = "El Jurado Nacional de Elecciones (JNE) confirmó mediante resolución oficial el cronograma para las Elecciones Municipales Complementarias, garantizando la supervisión técnica de la ONPE.",
            content = """
                El Jurado Nacional de Elecciones (JNE) ratificó de forma unánime el cronograma electoral definitivo dispuesto para llevar a cabo los comicios municipales complementarios en diversos distritos del país donde las votaciones anteriores fueron anuladas o suspendidas.

                De acuerdo con el organismo electoral, la Oficina Nacional de Procesos Electorales (ONPE) ya se encuentra desplegando la logística requerida para garantizar la instalación de las mesas de votación y la digitalización segura de actas electorales en tiempo real.

                Asimismo, se recordó a las organizaciones políticas el cumplimiento estricto de las normas sobre neutralidad estatal y financiamiento de campañas. Se habilitarán módulos digitales de fiscalización ciudadana para reportar cualquier irregularidad previa al día central del sufragio.
            """.trimIndent(),
            isViral = true,
            isSaved = false
        ),
        NewsArticle(
            id = "news_3",
            title = "Fiscalía abre investigación preliminar por presuntas irregularidades en licitaciones de transporte",
            source = "La República",
            timeAgo = "Ayer",
            category = "Judicial",
            imageUrl = "https://lh3.googleusercontent.com/aida-public/AB6AXuBi0tWXicwdkPvpTadu44ZDAjll73rDHOy-SfqJ3UMhuYPwyD2FZuJgKiVpRXsSkC2i9sEOmEvjUoKwiCptaXtIkNCN6eulAgr4c6BB3yWyRkk8FakFmzB2dFgTKDyEPfnZyc3q9PQhIFxZjaaoSsK4ZlYekm_TkduMSmZ2ByosP_Fdt9TGrKyjeqCxzSDrYIe0rX2WhhGhJbM3ZKlSZ0A4RrfbglnbstodsVt27ST2OMlL-rcn2G7EKRvZovbFlHyNfrqCIMHkoVoR",
            summary = "El Ministerio Público inició indagaciones tras recibir denuncias de sobrecostos en contratos de concesión vial e infraestructura urbana.",
            content = """
                El Área de Enriquecimiento Ilícito y Denuncias Constitucionales de la Fiscalía de la Nación formalizó el inicio de diligencias preliminares contra funcionarios del sector transportes para determinar eventuales responsabilidades penales en la adjudicación de obras viales.

                La investigación se centra en presuntos direccionamientos contractuales y variaciones presupuestales aprobadas mediante adendas sin el respaldo técnico suficiente. Equipos del Ministerio Público realizaron una visita de inspección documental en las sedes administrativas competentes.

                Fuentes fiscales indicaron que se citará a declarar a exautoridades y representantes legales de las firmas consorciadas durante los próximos 60 días calendario con la finalidad de recopilar peritajes financieros.
            """.trimIndent(),
            isViral = true,
            isSaved = false
        ),
        NewsArticle(
            id = "news_4",
            title = "Inversión privada en el sector minero muestra señales de recuperación tras anuncios del Ejecutivo",
            source = "Infobae",
            timeAgo = "Hace 1 día",
            category = "Economía",
            imageUrl = "https://lh3.googleusercontent.com/aida-public/AB6AXuAdS8D7dAHzUC0OB4ErhsOBo-b2u3kQ21KhRff5Ripmp11Bfq-7YzAo3HK5iqkVTxC__J8NyIHIIQpWsFIgNvqHB0BH7yS92y6phq5xjx8Mxa--gPS-Gu1gmAv2ieN8CWMrZx-qUeLqUgGugXRusYqrgDUj8XCl3CtTFK14a58Bca64jXfKpQkS7Ed0iaUnFAaepe779dmPIeSb3efsKlzgRlTQSkFJSp-dcd-2X-84vp6GZRQROixaPfg3Wlbu9dQ7F0si1esBvErf",
            summary = "Gremios empresariales señalan que la agilización de permisos ambientales y la ventanilla única para proyectos mineros generaron mayor confianza en los mercados globales.",
            content = """
                El flujo de capitales hacia proyectos de exploración y ampliación minera registró una reactivación del 4.8% interanual en el último trimestre, sustentado por las recientes medidas de simplificación administrativa promulgadas por el Gobierno.

                De acuerdo con informes de la Sociedad Nacional de Minería, Petróleo y Energía (SNMPE), la agilización en la aprobación de instrumentos de gestión ambiental ha reducido plazos críticos, devolviendo dinamismo a la cartera nacional de inversiones.

                Analistas económicos coinciden en que la estabilidad de los precios internacionales del cobre y zinc, sumada al diálogo oportuno con comunidades locales, será clave para consolidar esta tendencia positiva a lo largo del año.
            """.trimIndent(),
            isViral = true,
            isSaved = false
        ),
        NewsArticle(
            id = "news_5",
            title = "EXCLUSIVO: Los nexos no revelados entre asesores parlamentarios y empresas de construcción",
            source = "El Foco",
            timeAgo = "Hace 2 días",
            category = "Congreso",
            imageUrl = "https://lh3.googleusercontent.com/aida-public/AB6AXuBobae6VnQxbQi8xeZ2q54VXTnoUxVffMCxZqzIZ0hXybDGrNc8ZckWfksXvmBpsTkGufBZ1mEZlHEYsKWRaLXpAZn7CWAGym0EZH3HyL4KJo78vfBIzq1qBJBcocFxmnJxG5JrH-Q63bxAMARsxe63G8u1E4XcSHEbFOMJ_7u5HANRoQ2AMXsVQhj9QfSB2cdqUuE1KTkneVQoF3BCWMmGH24tN4n9eYxXIZgidJBIylG7ZbwTqddKwUIrhAdySPYCa9fDNhnag6ne",
            summary = "Un análisis documental de correos y bitácoras de acceso revela que asesores de importantes comisiones mantuvieron reuniones previas a dictámenes de obras públicas.",
            content = """
                Una investigación periodística exclusiva revela coincidencias en las agendas de trabajo de asesores principales pertenecientes a comisiones de infraestructura del Congreso y representantes de empresas contratistas del Estado.

                Los registros del portal de transparencia muestran visitas fuera del horario oficial y la posterior inclusión de modificaciones presupuestarias en proyectos de desarrollo regional. Diversas voces en el parlamento han solicitado que el Ética Parlamentaria asuma de oficio la revisión de estos antecedentes.

                Representantes de los despachos aludidos emitieron comunicados desmintiendo cualquier conflicto de interés y afirmando que las reuniones formaron parte de audiencias públicas regulares de recepción a gremios sectoriales.
            """.trimIndent(),
            isViral = true,
            isSaved = false
        ),
        NewsArticle(
            id = "news_6",
            title = "Gobernadores regionales solicitan mayor autonomía en la gestión de recursos para salud y educación",
            source = "RPP",
            timeAgo = "Hace 2 días",
            category = "Regiones",
            imageUrl = "https://lh3.googleusercontent.com/aida-public/AB6AXuAOFvjPoNk8gEIdCrhCphtLtARQC4GSJavOgOmXo5z7M-c8Rn3sjJcGM3lSnwsP70Dl9_nsDI5VDRlPAPWwbZLjRGook7zq-xpRQpPfgM61ujwzH_GO-ISwm8P1TLon111qTnG-ui49Aeg4qn2qnUtyx7oY9zgc1ThBAi4O2kPJjxt5gNm-vhZfEkiOQqD-Qsi3nwSQgafDddLRbYu1d1TURRdDdvf3VLGCq0nVdvCUrBKnznDPswSS5arCJrggpfbYALipLXsU0VtA",
            summary = "En el marco del V Gore Ejecutivo, los presidentes regionales acordaron solicitar la descentralización directa de partidas presupuestales para acelerar obras asistenciales.",
            content = """
                Los integrantes de la Asamblea Nacional de Gobiernos Regionales (ANGR) emitieron la Declaración de Lima, documento en el cual exhortan al Poder Ejecutivo a flexibilizar la burocracia en las transferencias de partidas para centros de salud de nivel I y II.

                Según expresaron las autoridades subnacionales, la centralización de licitaciones genera demoras de hasta ocho meses en la adquisición de equipamiento hospitalario y contratación de personal docente especializado.

                El Presidente del Consejo de Ministros (PCM) saludó la disposición al diálogo e informó que se instalarán mesas técnicas de trabajo para establecer compromisos de ejecución presupuestal transparente y medible trimestre a trimestre.
            """.trimIndent(),
            isViral = true,
            isSaved = false
        ),
        NewsArticle(
            id = "news_7",
            title = "Comisión de Constitución aprueba dictamen para fortalecer institucionalidad de organismos autónomos",
            source = "El Comercio",
            timeAgo = "Hace 3 días",
            category = "Congreso",
            imageUrl = "https://lh3.googleusercontent.com/aida-public/AB6AXuC8rh_OCNAEjz72mZA9ppOMWxSOjJJZ_MTzoPBTwBkWrdiUgQEHF4GVyfFnLBTnu3WC_1nDWNFmou28dt1Xpg7Uj8xacRwE0im6UoBjBo1R70TfSxyWj6F6Tpi9i1Hgq4-97sp3vR5FIB1FYDW0wH9F-t72XCUQI9hI9dPHhz6wKn6V-mQnx9iJvLxyGIKaMNp6M3xSOKayJ4pFcFK-smAHtQ4QLLfFKKbeyWyZkkpZgPu4Z72r5zRMWATLottLX8qhdqkexJMVLHZ9",
            summary = "La propuesta contempla nuevos mecanismos de selección mediante concurso público de méritos y evaluación de trayectoria profesional.",
            content = """
                La Comisión de Constitución y Reglamento del Congreso aprobó por mayoría el texto sustitutorio destinado a modificar los requisitos de designación para titulares de entes reguladores y de fiscalización.

                El proyecto establece que los postulantes deberán contar con al menos 15 años de ejercicio profesional intachable y someterse a entrevistas públicas transmitidas en directo. La iniciativa pasará a debate prioritario en el Pleno.
            """.trimIndent(),
            isViral = false,
            isSaved = false
        ),
        NewsArticle(
            id = "news_8",
            title = "BCR proyecta estabilidad monetaria e inflación en rango meta para el cierre del año fiscal",
            source = "Infobae",
            timeAgo = "Hace 3 días",
            category = "Economía",
            imageUrl = "https://lh3.googleusercontent.com/aida-public/AB6AXuAdS8D7dAHzUC0OB4ErhsOBo-b2u3kQ21KhRff5Ripmp11Bfq-7YzAo3HK5iqkVTxC__J8NyIHIIQpWsFIgNvqHB0BH7yS92y6phq5xjx8Mxa--gPS-Gu1gmAv2ieN8CWMrZx-qUeLqUgGugXRusYqrgDUj8XCl3CtTFK14a58Bca64jXfKpQkS7Ed0iaUnFAaepe779dmPIeSb3efsKlzgRlTQSkFJSp-dcd-2X-84vp6GZRQROixaPfg3Wlbu9dQ7F0si1esBvErf",
            summary = "El Banco Central de Reserva del Perú (BCRP) emitió su reporte de inflación destacando la solidez de las reservas internacionales de la República.",
            content = """
                El BCRP destacó en su más reciente informe trimestral que las expectativas de inflación a doce meses se ubican firmemente dentro del rango meta entre 1% y 3%.

                El directorio del ente emisor enfatizó que las reservas internacionales peruanas continúan siendo un sólido blindaje ante volatilidades financieras globales, lo que otorga predictibilidad a los emprendedores e inversionistas nacionales.
            """.trimIndent(),
            isViral = false,
            isSaved = false
        )
    )
}
