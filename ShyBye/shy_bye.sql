CREATE TABLE users(
user_id serial PRIMARY KEY,
username varchar (250),
passwrd varchar (250),
user_points int
);

INSERT INTO users( username, passwrd, user_points)
VALUES ('Example','password', 0);

SELECT * FROM users;

CREATE TABLE rewards(
reward_id serial PRIMARY KEY,
reward_name TEXT,
reward_description TEXT,
reward_image_url TEXT
);

INSERT INTO rewards (reward_name, reward_description, reward_image_url)
VALUES ('First Smile', 'You smiled at someone! Already a social butterfly!','<img src="/Assets/Badges/smiley1.jpg" alt="smiley Face">'),
('First Hello', 'You said hello to a friend! Nice!', '<img src="/Assets/Badges/hello.png" alt="hello">'),
('Eye Contact Initiator', 'You looked someone in the eye for the first time!', '<img src="/Assets/Badges/eye.png" alt="eye">'),


('How do you do?','You asked someone how they are doing today!', '<img src="/Assets/Badges/question.jpg" alt="question mark">'),
( 'Compliment', 'You gave a sincere compliment!', '<img src="/Assets/Badges/question.jpg" alt="question mark">'),
('Direction Dynomite', 'You asked someone for directions! Woot!', '<img src="/Assets/Badges/direction.png" alt="direction signs">'),

('Take Five', 'You started a five minute conversation with a stranger!', '<img src="/Assets/Badges/five.png" alt="five">'),
('Foodie Friends', 'Congrats! You invited a friend to eat out for the first time!', '<img src="/Assets/Badges/spoon-and-fork.png" alt="quoteBubbles">'),
('Party with your Elders', 'You connected with an elderly friend!', '<img src="/Assets/Badges/old-man.png" alt="quoteBubbles">'),

('Dinner Party Host', 'Wow! You hosted your first dinner party! Rock on!','<img src="/Assets/Badges/balloon.png" alt="balloon">' ),
('Date Night','You asked someone out on a date!', '<img src="/Assets/Badges/romantic-date.png" alt="couple holding hands">'),
('Mutual appreciation', 'You exchanged favors with a friend. Social contracts are what makes the world go round.','<img src="/Assets/Badges/fist-bump" alt="fist bump">'),

('Rejection Warrior', 'Congratulations! You have been successfully rejected!', '<img src="/Assets/Badges/thumbs-down.png" alt="thumbs down">' ),
('Public Speaker', 'You spoke in front of a crowd of people! Way to go!', '<img src="/Assets/Badges/speech.png" alt="speech">'),
('Crusher', 'You finally told your crush how you felt! Amazing!', '<img src="/Assets/Badges/in-love.png" alt="hearts for eyes smiley">');

SELECT * FROM rewards;

CREATE TABLE challenges(
challenge_id serial PRIMARY KEY,
challenge_name TEXT,
challenge_description TEXT,
challenge_points int,
difficulty TEXT,
reward_id_fk int REFERENCES rewards(reward_id) 
);

INSERT INTO challenges (challenge_name, challenge_description, challenge_points, difficulty, reward_id_fk)
VALUES ('Smile at someone today.', 'When you pass by an aquaintance give them a smile. It will brighten their day and yours as well!', 5, 'Gentle', 1),
('Say hello to a friend', 'Find someone with a friendly face and say hello to them!', 5,'Gentle', 2 ),
('Look someone in the eye', 'The next time someone talks to you, look them in the eye. Even if only for a moment!',5, 'Gentle', 3),

('Ask someone how they are doing', 'Whether you are in line at the grocery store or ordering food or passing someone on the street take a moment to ask how another person is doing.',10,'Easy', 4),
('Give someone a sincere compliment', 'Give someone a compliment! You could make their day and make a friend in the process.', 10, 'Easy', 5 ),
('Ask someone for directions', 'Even if you already know the way, try this experiment and make a connection!', 10, 'Easy',6 ),

('Have a five minute conversation with someone new', 'Get to know that friendly aquaintance better by striking up a conversation. Dont know what to talk about? Ask them what they like!', 20, 'Moderate',7 ),
('Invite a friend to eat out', 'Invite someone you want to get to know better to eat out with you.', 20, 'Moderate', 8 ),
('Interview an elderly friend about their life', 'If you have an elderly friend get to know them better. If you do not know anyone who is elderly visit a nursing home and make a new friend.', 20, 'Moderate', 9),

('Host a dinner party for two to five', 'Make dinner. Invite friends. Have fun!', 50, 'Hard', 10),
('Ask someone on a date', 'Work up the courage and ask someone out!',50, 'Hard',11 ),
('Ask a friend for a favor and then return the favor at a later time', 'Sometimes we struggle asking for help. But helping and being helped can bring a friendship to the next level.', 50, 'Hard',12 ),

('Purposely get rejected', 'Face your fear of rejection by doing something to purposely experience rejection. Ask for an item you know is not on the menu, ask a stranger for cash, ask the Uber driver if you can drive etc. Be creative!', 100, 'Nuclear', 13),
('Give a speech in front of an audience', 'Face your fear of public speaking. Join a toastmasters group or other public venue and speak in front of a group of people', 100, 'Nuclear',14 ),
('Tell your crush you like them, face-to-face', 'Have a crush but have not worked up the courage? Now is the time!', 100, 'Nuclear',15 );

SELECT * FROM challenges;

CREATE TABLE completed_challenges(
completed_challenge_id serial PRIMARY KEY,
user_id_fk int REFERENCES users(user_id),
challenge_id_fk int REFERENCES challenges(challenge_id)


);