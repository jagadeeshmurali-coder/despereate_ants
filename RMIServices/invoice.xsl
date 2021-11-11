<?xml version="1.0" encoding="ISO-8859-1"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
<xsl:output method='html' version='1.0' encoding='UTF-8' indent='yes'/>
<xsl:template match="/">
  <html>
  <body>
  <h2>Generate PDF from XML and XSLT StyleSheet Using iText, Flying Saucer and Java XSLT Transformer</h2>
    <table border="1">
      <tr bgcolor="#9acd32">
        <th align="left">Itemname</th>
        <th align="left">Unit</th>
        <th align="left">Price</th>
        <th align="left">Qty</th>
      </tr>
      <xsl:for-each select="invoice/items/item">
      		<tr>
        		<td><xsl:value-of select="itemname"/></td>
        		<td><xsl:value-of select="unit"/></td>
        		<td><xsl:value-of select="price"/></td>
        		<td><xsl:value-of select="qty"/></td>
      		</tr>
      </xsl:for-each>
    </table>    
  </body>
  </html>
</xsl:template>
</xsl:stylesheet>