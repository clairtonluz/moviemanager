INSERT INTO users (name, username, password, enabled)
VALUES ('Administrador', 'admin', '$2a$10$IV1.6EyW2KvKOhlLf8mFYuK6JEjWvrfqDXm1c9wPMcfQW2/ywaS4G', TRUE);

INSERT INTO user_role (user_id, role)
VALUES ((SELECT id
         FROM users
         WHERE username = 'admin'), 'ROLE_ADMIN');

INSERT INTO movie (name, description, url_image, year)
VALUES (
  'Guardiões da Galáxia Vol. 2',
  'Os Guardiões precisam lutar para manter sua recém descoberta família unida, enquanto descobrem os mistérios sobre o verdadeiro pai de Peter Quill. Antigos inimigos se tornam aliados e personagens conhecidos e amados dos quadrinhos virão ao auxílio dos heróis.',
  'https://media.xogrp.com/images/7f51967f-d80f-4daa-a893-80267e073fdd~rt_0-cr_0.0.1024.1024-rs_1024.h?compress=true',
  2017
), (
  'Velozes e Furiosos 8',
  'Depois que Brian e Mia se aposentaram, e o resto da equipe foi exonerado, Dom e Letty estão em lua de mel e levam uma vida pacata e completamente normal. Mas a adrenalina do passado acaba voltando com tudo quando uma mulher misteriosa faz com que Dom retorne ao mundo do crime e da velocidade.',
  'https://i.ytimg.com/vi/VN-3tNc_wXs/maxresdefault.jpg',
  2017
), (
  'O Poderoso Chefinho',
  'Um bebê falante que usa terno e carrega uma maleta misteriosa une forças com seu irmão mais velho invejoso para impedir que um inescrupuloso CEO acabe com o amor no mundo. A missão é salvar os pais, impedir a catástrofe e provar que o mais intenso dos sentimentos é uma poderosa força.',
  'https://baixarviatorrent.com.br/wp-content/uploads/2017/03/o-poderoso-chefinho.jpg',
  2017
);

INSERT INTO type (name)
VALUES ('AÇÃO'),
  ('Comédia'),
  ('Terror'),
  ('Suspense'),
  ('Animação'),
  ('Histórias reais'),
  ('Heróis'),
  ('Luta'),
  ('Ficção cientifica'),
  ('Drama'),
  ('Romantico'),
  ('Musicais');