import { useIntl } from 'umi';
import { GithubOutlined } from '@ant-design/icons';
import { DefaultFooter } from '@ant-design/pro-layout';

const Footer = () => {
  const intl = useIntl();
 

  const currentYear = new Date().getFullYear();
  return (
    <DefaultFooter
      copyright={`${currentYear} 铭天智能（天津）有限公司出品`}
      links={[
        
      ]}
    />
  );
};

export default Footer;
