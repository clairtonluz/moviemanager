INSERT INTO users (name, username, password, enabled) VALUES
('Administrador', 'admin', '$2a$10$IV1.6EyW2KvKOhlLf8mFYuK6JEjWvrfqDXm1c9wPMcfQW2/ywaS4G', TRUE),
('Clairton', 'clairton', '$2a$10$IV1.6EyW2KvKOhlLf8mFYuK6JEjWvrfqDXm1c9wPMcfQW2/ywaS4G', TRUE);

INSERT INTO user_role (user_id, role)
VALUES ((SELECT id
         FROM users
         WHERE username = 'admin'), 'ROLE_ADMIN');

INSERT INTO user_role (user_id, role)
VALUES ((SELECT id
         FROM users
         WHERE username = 'clairton'), 'ROLE_ADMIN');

INSERT INTO movie (name, url_image, description, year) VALUES
('Homem-Formiga','http://humanoides.com.br/wp-content/uploads/2015/07/homemformiga5-770x439_c.jpg','Forçado a sair de sua própria empresa, Dr. Hank Pym transforma um talentoso ladrão em Homem-Formiga para impedir que seu antigo pupilo consiga replicar a fórmula da roupa que dá o poder do encolhimento, força sobre-humana e a capacidade de controlar um exército de formigas',2015),
('Velozes e Furiosos 8','https://i.ytimg.com/vi/VN-3tNc_wXs/maxresdefault.jpg','Depois que Brian e Mia se aposentaram, e o resto da equipe foi exonerado, Dom e Letty estão em lua de mel e levam uma vida pacata e completamente normal. Mas a adrenalina do passado acaba voltando com tudo quando uma mulher misteriosa faz com que Dom retorne ao mundo do crime e da velocidade.',2017),
('Guardiões da Galáxia Vol. 2','https://conteudo.imguol.com.br/c/entretenimento/89/2017/04/25/poster-de-guardioes-da-galaxia-vol-2-de-james-gunn-1493148532817_v2_1920x1080.jpg','Os Guardiões precisam lutar para manter sua recém descoberta família unida, enquanto descobrem os mistérios sobre o verdadeiro pai de Peter Quill. Antigos inimigos se tornam aliados e personagens conhecidos e amados dos quadrinhos virão ao auxílio dos heróis.',2017),
('O Poderoso Chefinho','https://baixarviatorrent.com.br/wp-content/uploads/2017/03/o-poderoso-chefinho.jpg','Um bebê falante que usa terno e carrega uma maleta misteriosa une forças com seu irmão mais velho invejoso para impedir que um inescrupuloso CEO acabe com o amor no mundo. A missão é salvar os pais, impedir a catástrofe e provar que o mais intenso dos sentimentos é uma poderosa força.',2017),
('Esquadrão suicida','http://ahoradofilme.com.br/wp-content/uploads/2016/08/esquadraosuicida_29-750x380.jpg','Um time dos mais perigosos e encarcerados supervilões são contratados por uma agência secreta do governo, para combater uma poderosa entidade. No entanto, quando eles percebem que não foram escolhidos apenas para ter sucesso, mas também por sua óbvia culpa quando inevitavelmente falharem, terão que decidir se vale a pena ou não continuar correndo risco de morte.',2017);
