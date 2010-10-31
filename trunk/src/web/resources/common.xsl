<?xml version="1.0" encoding="windows-1251"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
    <xsl:output method="html" indent="yes" encoding="windows-1251"/>

    <xsl:key match="/page/items/item" name="item" use="@uid"/>

    <xsl:template match="/">
        <html>
        <head>
            <title><xsl:text>���������</xsl:text></title>
            <link type="text/css" rel="stylesheet" href="attraction.css"/>
        </head>
        <body>
            <table width="100%" align="center">
                <tr width="100%" align="center">
                   ���������
                </tr>
                <tr>
                   <td width="20%" align="left">
                       ������ ����������������������
                       <xsl:call-template name="menu"/>
                   </td>
                   <td width="80%" align="left">
                       ������� �����:
                          <xsl:call-template name="find"/>
                       ��������� �������: <br/>
                          <xsl:call-template name="main"/>
                   </td>
                  <!-- <td width="33%" align="center">
                       �������
                   </td>-->
                </tr>

            </table>
        </body>
        </html>
    </xsl:template>

    <xsl:template name="find">
        <form action="attractions.xml" method="post">
            <table>
                <tr>
                    <td>
                        <input name="findTextBox" type="text"/>
                    </td>
                    <td colspan="4" class="footer" align="center">
                        <input type="submit" value="�����" class="ok-button"/>
                    </td>
                </tr>
            </table>
        </form>
    </xsl:template>

    <xsl:template name="menu">
        <br/> �������
        <br/> �������
        <br/> �������
        <br/> �������
        <br/> �������

    </xsl:template>

</xsl:stylesheet>