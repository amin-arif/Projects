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
    public partial class UsersControl : UserControl
    {
        System.Windows.Forms.Panel mainFormPanel;
        public UsersControl()
        {
            InitializeComponent();
        }

        public UsersControl(System.Windows.Forms.Panel mainFormPanel)
        {
            this.mainFormPanel = mainFormPanel;
        }

        private void Label3_Click(object sender, EventArgs e)
        {

        }

        private void UsersControl_Load(object sender, EventArgs e)
        {

        }
    }
}
