package br.beans.menssagem;

public class Menssagem {

	public static String cadastro(final String nome, final String login,
			final String senha) {
		return "<html>"
				+ "<head>"
				+ "<title>CONFIRMA��O DE CADASTRO!</title>"
				+ "</head>"
				+ "<body>"
				+ "<div>"
				+ "Ol� "
				+ nome
				+ "!<br/>"
				+ "Seu cadastro no site AlugeSustentavel foi feito com sucesso.<br/>"
				+ "Seu login: "
				+ login

				+ "<br/>Sua senha: "
				+ senha

				+ "<br/>Agora, voc� poder� Alugar a vontade. "
				+ "<br/>Para confirmar o seu cadastramento no site e poder usufruir totalmente do AlugeSustentavel,"
				+ "<br/>por favor clique no link a seguir."
				+ "</div>"
				+ "<div style='width:28%; height:50px;' align='center'>"
				+ "<br/>"
				+ "<a href='http://localhost:8089/aluguesustentavel/'> AlugeSustentavel </a> </body>"
				+ "</html>";
	}

	public static String recuperarSenha(final String nome, final String login,
			final String senha) {
		return "<html>"
				+ "<head>"
				+ "<title>NOVA SENHA!</title>"
				+ "</head>"
				+ "<body>"
				+ "<div>"
				+ "Ol� "
				+ nome
				+ "!"
				+ "<br/>Voc� enviou uma solicita��o de nova senha para o LachoNet<br/>"
				+ "Seu login: "
				+ login
				+ "<br/>Sua senha: "
				+ senha
				+ "<br/>Para trocar de senha apenas fa�a o login e altere sua senha.<br/>"
				+ "<div style='width:28%; height:50px;' align='center'>"
				+ "<br/>"
				+ "<a href='http://localhost:8089/aluguesustentavel/'> AlugeSustentavel </a> </body>"
				+ "</html>";
	}

}
