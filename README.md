# struts2_rce_attack_filter 

# Reference
https://cwiki.apache.org/confluence/display/WW/S2-045

# Audience
Struts 2 Developers


# Vulnerability and its risks

Possible RCE when performing file upload based on Jakarta Multipart parser
Maximum security rating High

# Recommendation

Upgrade to Struts 2.3.32 or Struts 2.5.10.1

# Affected Struts versions
Struts 2.3.5 - Struts 2.3.31, Struts 2.5 - Struts 2.5.10

# Description

Filter to intercept all requests that are coming to the struts2 application and then reject the invalid content Types,its a simple workaround as you prepare to migrate to the latest stable release of struts as recommended by the struts team.

The recommended versions as mentioned in the wiki are shown above.

# Installation

Include the filter in your web.xml 

 <filter>
    <filter-name>part</filter-name>
    <filter-class>test.MultipartRequestFilter</filter-class>
  </filter>

  <filter-mapping>
   <filter-name>part</filter-name>
    <url-pattern>/*</url-pattern>
 </filter-mapping>


# Contact and assistance
  feel free to use the filter and contact for anyissue in installing or configuring the filter.
  fredndk@gmail.com


