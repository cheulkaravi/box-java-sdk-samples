package com.box.samples.aws.sns;

import java.util.Properties;

/**
 * Configuration for {@link BoxAWSSNSLambda}.
 *
 * @author Stanislav Dvorscak
 *
 */
public class Configuration {

    /**
     * @see {@link #getTableNameTopicByWebhook()}
     */
    private final String tableNameTopicByWebhook;

    /**
     * @see #getBoxClientId()
     */
    private final String boxClientId;

    /**
     * @see #getBoxClientSecret()
     */
    private final String boxClientSecret;

    /**
     * @see #getBoxPublicKeyId()
     */
    private final String boxPublicKeyId;

    /**
     * @see #getBoxPrivateKey()
     */
    private final String boxPrivateKey;

    /**
     * @see #getBoxPrivateKeyPassword()
     */
    private final String boxPrivateKeyPassword;

    /**
     * Constructor.
     *
     * @param properties
     *            loaded {@link Properties}
     */
    public Configuration(Properties properties) {
        // AWS DynamoDB
        this.tableNameTopicByWebhook = properties.getProperty("dynamodb.table.topic_by_webhook");

        // box
        this.boxClientId = properties.getProperty("box.clientId");
        this.boxClientSecret = properties.getProperty("box.clientSecret");
        this.boxPublicKeyId = properties.getProperty("box.publicKeyId");
        this.boxPrivateKey = properties.getProperty("box.privateKey");
        this.boxPrivateKeyPassword = properties.getProperty("box.privateKeyPassword");
    }

    /**
     * @return table name for Web Hook SNS ARN mapping.
     */
    public String getTableNameTopicByWebhook() {
        return this.tableNameTopicByWebhook;
    }

    /**
     * @return Box Application client ID.
     */
    public String getBoxClientId() {
        return this.boxClientId;
    }

    /**
     * @return appropriate client secret to {@link #getBoxClientId()}
     */
    public String getBoxClientSecret() {
        return this.boxClientSecret;
    }

    /**
     * @return RSA Public key "ID" for Box Application authentication.
     * @see #getBoxPrivateKey()
     */
    public String getBoxPublicKeyId() {
        return this.boxPublicKeyId;
    }

    /**
     * @return Encrypted private key corresponding to {@link #getBoxPublicKeyId()}.
     * @see #getBoxPrivateKeyPassword()
     */
    public String getBoxPrivateKey() {
        return this.boxPrivateKey;
    }

    /**
     * @return De-cryption password for a provided {@link #getBoxPrivateKey()}
     */
    public String getBoxPrivateKeyPassword() {
        return this.boxPrivateKeyPassword;
    }

}
