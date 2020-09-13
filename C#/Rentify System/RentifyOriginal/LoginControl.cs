using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Drawing;
using System.Data;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace RentifyOriginal
{
    public partial class LoginControl : UserControl
    {
        System.Windows.Forms.Panel mainFormPanel;
        public LoginControl()
        {
            InitializeComponent();
        }

        public LoginControl(System.Windows.Forms.Panel p)
        {
            mainFormPanel = p;
            InitializeComponent();

        }

        private void LoginControl_Load(object sender, EventArgs e)
        {

        }

        private void Button1_Click(object sender, EventArgs e)
        {
            mainFormPanel.Controls.Clear();
            mainFormPanel.Controls.Add(new SignupControl());
        }

        private void UserLoginButton_Click(object sender, EventArgs e)
        {
            mainFormPanel.Controls.Clear();
            mainFormPanel.Controls.Add(new UsersControl());
        }
    }
}
