 - Relógio Digital e Analógico integrados
 
 Como usar: 
 	O botão A altera o relógio para Modo de Exibição,
 Modo de Ajuste das Horas e Modo de Ajuste dos Minutos respectivamente.
 	O botão B incrementa as Horas e os Minutos dependendo do seu estado.


Projeto>

 Desing Pattern usados:
 	- State
 	- Facade
 	- Observer
 	- Singleton
 	
Pacotes>
	Fachada: Possui a Classe ClockFacade usada para integrar comandos da interface lógica para
			 a interface gráfica.
	GraphicInterface: Possui as Classes usadas para desenhar cada relógio e os botões.
	LogicalInterface: Possui a Classe Clock implementada em padrão State que comanda e atualiza
					  as horas, minutos e segundos do relógio a cada DELAY de 1000 milisegundos.
	Main: Classe Main para executar o projeto.
	ObserverPackage: Possui a interface Observer e Subject usada para integrar a interface lógica com
					 a interface gráfica.
