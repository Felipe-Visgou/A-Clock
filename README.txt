 - Rel�gio Digital e Anal�gico integrados
 
 Como usar: 
 	O bot�o A altera o rel�gio para Modo de Exibi��o,
 Modo de Ajuste das Horas e Modo de Ajuste dos Minutos respectivamente.
 	O bot�o B incrementa as Horas e os Minutos dependendo do seu estado.


Projeto>

 Desing Pattern usados:
 	- State
 	- Facade
 	- Observer
 	- Singleton
 	
Pacotes>
	Fachada: Possui a Classe ClockFacade usada para integrar comandos da interface l�gica para
			 a interface gr�fica.
	GraphicInterface: Possui as Classes usadas para desenhar cada rel�gio e os bot�es.
	LogicalInterface: Possui a Classe Clock implementada em padr�o State que comanda e atualiza
					  as horas, minutos e segundos do rel�gio a cada DELAY de 1000 milisegundos.
	Main: Classe Main para executar o projeto.
	ObserverPackage: Possui a interface Observer e Subject usada para integrar a interface l�gica com
					 a interface gr�fica.
