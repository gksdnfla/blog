INSERT INTO
    users (
        `username`,
        `password`,
        `nickname`,
        `email`,
        `role`,
        `createBy`,
        `updateBy`
    )
VALUES
    (
        "yulin4434",
        "$2a$10$X2pi0Yx9sWrOkeeoxcdP1OEN0TofvlETIFQGcxINSNX0zLZMDm63O",
        "관리자",
        "972839577@qq.com",
        "ROLE_ADMIN",
        1,
        1
    ) ON DUPLICATE KEY
UPDATE
    createBy = 1;