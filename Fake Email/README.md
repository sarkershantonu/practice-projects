# Fake Email 
Example to use emailing in your test

This is a fake email server , main project => https://sourceforge.net/projects/fakemail/
Download and run (it is present in resources)
I run with no specific settings (my free port was 9500)

# Running server
python fakemail.py --host=0.0.0.0 --port=9500

We can define log/email folder like this =>

python /home/shantonu/fakemail/fakemail.py --host=0.0.0.0 --port=9500 --path=/home/shantonu/fakemail/mail --log=/home/shantonu/fakemail/log --background

So, after running, if you try to send email, you will recieve all email as file where all recipient names will be the file name

this is one of email recipent

=====
Date: Sun, 14 Aug 2016 01:51:03 +0200 (CEST)
From: sarker.shantonu@gmail.com
To: to@shantonu.com, tk@saumen.com
Message-ID: <110718392.0.1471132263644.JavaMail.shantonu@shantonu-brix>
Subject: Test from local host
MIME-Version: 1.0
Content-Type: text/plain; charset=us-ascii
Content-Transfer-Encoding: 7bit

Dummy email
========

We can use this for dummey email checks on test fail.
