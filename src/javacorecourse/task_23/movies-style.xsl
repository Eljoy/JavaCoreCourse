<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

    <xsl:template match="/">
        <html>
            <head></head>
            <body>
                <table border="1" cellpadding="4" cellspacing="0">
                    <tr bgcolor="#999999" align="center">
                        <th>Title</th>
                        <th>Genre</th>
                        <th>Format</th>
                        <th>Year</th>
                        <th>Rating</th>
                        <th>Stars</th>
                        <th>Description</th>
                        <th>Awards</th>
                    </tr>
                    <xsl:for-each select="collection/movie">
                        <tr>
                            <td><xsl:value-of select="../@title"/></td>
                          <!--<td><xsl:value-of select="ancestor::movie/@title"/></td> -->
                            <td><xsl:value-of select="genre"/></td>
                            <td><xsl:value-of select="format"/></td>
                            <td><xsl:value-of select="year"/></td>
                            <td><xsl:value-of select="rating"/></td>
                            <td><xsl:value-of select="stars"/></td>
                            <td><xsl:value-of select="description"/></td>
                            <td><xsl:value-of select="awards"/></td>
                        </tr>
                    </xsl:for-each>
                </table>
            </body>
        </html>
    </xsl:template>
</xsl:stylesheet>