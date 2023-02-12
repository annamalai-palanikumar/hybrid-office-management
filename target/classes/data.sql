INSERT INTO identity_client (id, name, client_id) VALUES (1, 'GOOGLE', '204034911117-a3ta87crrp5k68najd5affe5f6395eb1.apps.googleusercontent.com');

INSERT INTO employee (id, name, email, admin) VALUES (1, 'Annamalai Palanikumar', 'annamalai10051996@gmail.com', true);

INSERT INTO office (id, name, plan) VALUES (1, 'India Office', '/india-office-plan.webp');

INSERT INTO office (id, name, plan) VALUES (2, 'Sweden Office', '/sweden-office-plan.webp');

INSERT INTO office_area (id, office_id, shape, coords) VALUES (1, 1, 'circle', '337, 300, 44');

INSERT INTO office_area (id, office_id, shape, coords) VALUES (2, 2, 'circle', '337, 300, 44');

INSERT INTO area_booking (id, area_id, employee_id, start, end) VALUES (1, 1, 1, '2023-02-10 09:00:00', '2023-02-10 17:00:00');