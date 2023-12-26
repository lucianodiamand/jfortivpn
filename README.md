
Requirements

The jfortivpn project dependes on openfortivpn. To install in Ubuntu run:

```
sudo apt install openfortivpn
```

Once installed you can test the configuration manually.

We have to create the configuration file in ower home directory:

```
.jfortivpn.yml
```

The format of the file is:

```
profiles:
  - name: production
    vpn_config: <path_to_openfortivpn_config_file>
    otp_prompt: "Two-factor authentication token:"
    search_delay: 2s
    search_sender: <email_sender>
    search_mailbox: OTP
    search_within: 60s
    search_field: Subject
    search_regex: 'Token code: (\d+)'
    imap:
      host: imap.gmail.com
      port: 993
      username: <your_email>
      password: <the_password>
```

```
./gradlew fatLib
```

```
sudo java -jar jfortivpn-project.jar
```


