#include<cstdio>
#include <GL/gl.h>
#include <GL/glut.h>
#include<iostream>
#include<math.h>
#include<windows.h>
#include <string>
#include<stdio.h>

using namespace std;

//char message1[]="Game Over";
//char message[]="press space to start playing";

const int font1=(int)GLUT_BITMAP_TIMES_ROMAN_24;
const int font2=(int)GLUT_BITMAP_HELVETICA_18;
const int font3=(int)GLUT_BITMAP_HELVETICA_10;
void renderBitmapString(float x, float y, void *font,const char *string)
{
    const char *c;
    glRasterPos2f(x, y);
    for (c=string; *c != '\0'; c++) {
        glutBitmapCharacter(font, *c);
    }
}

GLfloat oc1r=0,oc1g=0,oc1b=1.0,oc3r=1.0,oc3g=0.0,oc3b=0.0,oc5r=1.0,oc5g=1.0,oc5b=0.0,rand1=-0.0f,rand3=0.0f;
GLfloat position =0.0f,bossposition=0.0f;
GLfloat lr = 0.0f,ud = 0.0f,lrud=0.1;
GLfloat speed = 0.1f;
GLfloat randd=0.1;
GLfloat b1x=0.0f,b1y=0.0f,b2x=0.0f,b2y=0.0f,b3x=0.0f,b3y=0.0f,b4x=0.0f,b4y=0.0f,b5x=0.0f,b5y=0.0f;
bool flag=0,flag1=0,flag3=0,flag5=0,start=0,over=0;
int countt=0,fault=0;

void randdd(int r)
{
    if(rand1 > 0.90 && start)
             rand1 =-0.90f;
             else
             rand1 +=randd;
             if(rand3<  -0.900 && start)
             rand3 =0.90f;
             else
             rand3 -=randd;
      glutPostRedisplay();

}

void bu1(int b1)
{
        if(b1y > 2.0)
        {
           b1y =ud;
           b1x=lr;
        }

              b1y+=speed;


      glutPostRedisplay();




}

void bu2(int b1)
{
        if(b2y > 2.0)
        {
           b2y =ud;
           b2x=lr;
        }

              b2y+=speed;


      glutPostRedisplay();

}

void bu3(int b1)
{
        if(b3y > 2.0)
        {
           b3y =ud;
           b3x=lr;
        }

              b3y+=speed;


      glutPostRedisplay();

}

void bu4(int b1)
{
        if(b4y > 2.0)
        {
           b4y =ud;
           b4x=lr;
        }

              b4y+=speed;


      glutPostRedisplay();
}



void bu5(int b1)
{
        if(b5y > 2.0)
        {
           b5y =ud;
           b5x=lr;
        }

              b5y+=speed;


      glutPostRedisplay();


	glutTimerFunc(5,bu5, 0);
	glutTimerFunc(25,bu1, 0);
	glutTimerFunc(47,bu2, 0);
	glutTimerFunc(69,bu3, 0);
	glutTimerFunc(91,bu4, 0);



}

void colour(int value)
{



    if(position < -2.0)
    {
         oc1g=0.0;
        oc1b=1.0;
        oc3r=1.00;
        oc3g=0.00;
        oc3b=0.00;
    }
    glutPostRedisplay();


	glutTimerFunc(15,colour, 0);
}



void update(int value)
{

    if(position < -2.0 && start)
    {


        position = 1.0f;

        flag1=!flag1;
        flag3=!flag3;
        flag5=!flag5;
        glutTimerFunc(0, randdd, 0);

    }
    position -=speed;



	if(start)
    {
            if(position < -2.0)
    {

         if(oc1b==1.00 && rand1<0.8 )
    {
        if(rand1>-0.8)
        fault=fault+1;
    }
           if(oc3r==1.00 && rand3<0.8 )
    {
        if( rand3>-0.8)
        fault=fault+1;
    }
    }
    }
    cout<<"fault"<<fault<<endl;

    if(fault>30)
    {
        over=1;
        start=0;
    }
    if(over)
    {
       speed = 0.0f;
       randd=0.0f;
       lrud=0.0f;
        cout<<"your score is :"<<countt*10<<endl;

    }

glutPostRedisplay();

	if(!over)
    {
        glutTimerFunc(60, update, 0);
    }
}

void init() {
   glClearColor(0.0f, 0.18f, 0.08f, 0.0f);
}


void handleKeypress(unsigned char key, int x, int y) {


	switch (key) {

case 'p':
    if(!flag)
    {
       speed = 0.0f;
       randd=0.0f;
       lrud=0.0f;

    }
    if(flag)
    {
      speed = 0.1f;
      randd=0.1;
      lrud=0.1;

    }
     flag=!flag;
    break;
    case 'd':
    if(lr<1.00)
    {
        lr= lr+lrud;
    if(b1x==lr+.1 || b2x==lr+.1 || b3x==lr+.1 || b4x==lr+.1 || b5x==lr+.1)
    {
    b1x=b1x+.1;
    b2x=b2x+.1;
    b3x=b3x+.1;
    b4x=b4x+.1;
    b5x=b5x+.1;
    }

    }
    break;
case 'a':
    if(lr>-1.00)
    {
        lr= lr-lrud;
    if(b1x==lr-.1 || b2x==lr-.1 || b3x==lr-.1 || b4x==lr-.1 || b5x==lr-.1)
    {
    b1x=b1x-.1;
    b2x=b2x-.1;
    b3x=b3x-.1;
    b4x=b4x-.1;
    b5x=b5x-.1;
    }
    }
    break;
    case 'w':
    if(ud<.7)
    {
        ud= ud+lrud;
    if(b1y==lr+.1 || b2y==lr+.1 || b3y==lr+.1 || b4y==lr+.1 || b5y==lr+.1)
    {
    b1y=b1y+.1;
    b2y=b2y+.1;
    b3y=b3y+.1;
    b4y=b4y+.1;
    b5y=b5y+.1;
    }
    }

    break;
case 's':
    if(ud>-0.0)
    {
      ud= ud-lrud;
    if(b1y==lr-.05 || b2y==lr-.05 || b3y==lr-.05 || b4y==lr-.05 || b5y==lr-.05)
    {
    b1y=b1y-.1;
    b2y=b2y-.1;
    b3y=b3y-.1;
    b4y=b4y-.1;
    b5y=b5y-.1;
    }

    }
case ' ':
    start=1;

    break;
case 'e':
    exit(0);
    break;

glutPostRedisplay();


	}
}

void homeGame()
{

    gluOrtho2D(0,100,0,100);
    glColor3ub(255,255, 0);
    renderBitmapString(33,90,(void *)font1,"Fatao Game");
    glBegin(GL_QUADS);
    glColor3b(285,0,0);
    glVertex2i(17,83);
    glVertex2i(85,83);
    glVertex2i(85,64);
    glVertex2i(17,64);
    glEnd();
    glColor3ub(255,255,255);
    renderBitmapString(20,75,(void*)font2,"Press Space Button to Srart");
    renderBitmapString(20,70,(void*)font2,"Press E Button to Exit");

    glColor3ub(145,255,136);
    renderBitmapString(35,40,(void*)font3,"Press A to turn Left");
    renderBitmapString(35,37,(void*)font3,"Press D to turn Right");
    renderBitmapString(35,34,(void*)font3,"Press W to Up");
    renderBitmapString(35,31,(void*)font3,"Press S to Down");
    renderBitmapString(35,28,(void*)font3,"Press P to Pause");
}
void endGame()
{
    gluOrtho2D(0,100,0,100);
    glColor3ub(255,0, 0);
    renderBitmapString(32,55,(void *)font1,"Game Over");
    char r[50];
    sprintf (r, "SCORE: %d", countt*10);
    glColor3ub(255, 255, 0);
    renderBitmapString(32,45,(void *)font1,r);
}

void display()
{
   glClear(GL_COLOR_BUFFER_BIT);
   glLoadIdentity();
   if(!start && !over)
   {
        homeGame();

        /*glClearColor(0.0, 0.180, 0.08, 1.0);
        glLoadIdentity();
  glClear(GL_COLOR_BUFFER_BIT);
  glColor3f(1.0, 1.0, 1.0);
  glLineWidth(3.0);


  glMatrixMode(GL_PROJECTION);
  glLoadIdentity();
  gluOrtho2D(0, 2500, 0, 2500);

  glPushMatrix();
  glTranslatef(400,1200,0);
  for (int i = 0; i < strlen(message); i++) {
    glutStrokeCharacter(GLUT_STROKE_ROMAN, message[i]);
  }
  glPopMatrix();*/
  glutSwapBuffers();
  }




    if(over)
        {
            endGame();
       /*glClearColor(0.0, 0.0, 0.3, 1.0);
  glClear(GL_COLOR_BUFFER_BIT);
  glColor3f(1.0, 1.0, 1.0);
  glLineWidth(3.0);


  glMatrixMode(GL_PROJECTION);
  glLoadIdentity();
  gluOrtho2D(0, 2500, 0, 2500);

  glPushMatrix();
  glTranslatef(700,1200,0);
  for (int i = 0; i < strlen(message1); i++) {
    glutStrokeCharacter(GLUT_STROKE_ROMAN, message1[i]);
  }
  glPopMatrix();*/
  glutSwapBuffers();
        }

if(start)
{
    //score
    char result[50];
    sprintf (result, "SCORE : %d", countt*10);
    glColor3ub(255, 255, 0);
    renderBitmapString(.6f,.9f,(void *)font3,result);

    glPushMatrix();
glTranslatef(lr,ud, 0.0f);

//fire
glBegin(GL_TRIANGLES);
      glColor3f(1.0f, 0.0f, 0.0f);
      glVertex2f(-0.0f, -.815f);
      glVertex2f( 0.014f,  -0.875f);
      glVertex2f( -0.014f,  -0.875f);
      glEnd();

      glBegin(GL_TRIANGLES);
      glColor3f(1.0f, 0.0f, 0.0f);
      glVertex2f( 0.014f,  -0.875f);
      glVertex2f( -0.014f,  -0.875f);
      glVertex2f(-0.0f, -.935f);
      glEnd();


      glBegin(GL_TRIANGLES);
      glColor3f(1.0f, 1.0f, 0.0f);
      glVertex2f(-0.0f, -.815f);
      glVertex2f( 0.009f,  -0.875f);
      glVertex2f( -0.009f,  -0.875f);
      glEnd();

      glBegin(GL_TRIANGLES);
      glColor3f(1.0f, 1.0f, 0.0f);
      glVertex2f( 0.009f,  -0.875f);
      glVertex2f( -0.009f,  -0.875f);
      glVertex2f(-0.0f, -.907f);
      glEnd();
//fire


//downside
   glBegin(GL_QUADS);
      glColor3f(.0f, 0.0f, 1.0f);
      glVertex2f(-0.016f, -.85f);
      glVertex2f( 0.016f,  -0.85f);
      glVertex2f( 0.027f, -0.81f);
      glVertex2f(-0.027f,  -0.81f);
      glEnd();

//wing
      glBegin(GL_QUADS);
      glColor3f(0.82f, 0.82f, 0.82f);
      glVertex2f( 0.048f, -0.81f);
      glVertex2f(-0.048f,  -0.81f);
      glVertex2f(-0.048f, -.76f);
      glVertex2f( 0.048f,  -0.76f);
      glEnd();

      glBegin(GL_TRIANGLES);
      glColor3f(0.82f, 0.82f, 0.82f);
      glVertex2f( 0.048f, -0.81f);
      glVertex2f( 0.048f,  -0.76f);
      glVertex2f( 0.0525f, -0.785f);
      glEnd();

      glBegin(GL_TRIANGLES);
      glColor3f(0.82f, 0.82f, 0.82f);
      glVertex2f( -0.048f, -0.81f);
      glVertex2f( -0.048f,  -0.76f);
      glVertex2f( -0.0525f, -0.785f);
      glEnd();

//upside
      glBegin(GL_QUADS);
      glColor3f(0.0f, 0.0f, 1.0f);
      glVertex2f(-0.027f, -.76f);
      glVertex2f( 0.027f,  -0.76f);
      glVertex2f( 0.014f, -0.70f);
      glVertex2f(-0.014f,  -0.70f);
      glEnd();

      glBegin(GL_QUADS);
      glColor3f(1.0f, 1.0f, 1.0f);
      glVertex2f(-0.007f, -.70f);
      glVertex2f( 0.007f,  -0.70f);
      glVertex2f( 0.007f, -0.680f);
      glVertex2f(-0.007f,  -0.680f);
      glEnd();
glPopMatrix();



//bullet1

      glBegin(GL_QUADS);
      glColor3f(1.0f, 1.0f, 1.0f);
      glVertex2f(-0.007f+b1x, -.70f+b1y);
      glVertex2f( 0.007f+b1x,  -0.70f+b1y);
      glVertex2f( 0.007f+b1x, -0.680f+b1y);
      glVertex2f(-0.007f+b1x,  -0.680f+b1y);
      glEnd();

//bullet2
      glBegin(GL_QUADS);
      glColor3f(1.0, 1.0f, 1.0f);
      glVertex2f(-0.007f+b2x, -.70f+b2y);
      glVertex2f( 0.007f+b2x,  -0.70f+b2y);
      glVertex2f( 0.007f+b2x, -0.680f+b2y);
      glVertex2f(-0.007f+b2x,  -0.680f+b2y);
      glEnd();



//bullet3
      glBegin(GL_QUADS);
      glColor3f(1.0f, 1.0f, 1.0f);
      glVertex2f(-0.007f+b3x, -.70f+b3y);
      glVertex2f( 0.007f+b3x,  -0.70f+b3y);
      glVertex2f( 0.007f+b3x, -0.680f+b3y);
      glVertex2f(-0.007f+b3x,  -0.680f+b3y);
      glEnd();
 //bullet4
      glBegin(GL_QUADS);
      glColor3f(1.0f, 1.0f, 1.0f);
      glVertex2f(-0.007f+b4x, -.70f+b4y);
      glVertex2f( 0.007f+b4x,  -0.70f+b4y);
      glVertex2f( 0.007f+b4x, -0.680f+b4y);
      glVertex2f(-0.007f+b4x,  -0.680f+b4y);
      glEnd();

 //bullet5
      glBegin(GL_QUADS);
      glColor3f(1.0f, 1.0f, 0.0f);
      glVertex2f(-0.007f+b5x, -.70f+b5y);
      glVertex2f( 0.007f+b5x,  -0.70f+b5y);
      glVertex2f( 0.007f+b5x, -0.680f+b5y);
      glVertex2f(-0.007f+b5x,  -0.680f+b5y);
      glEnd();

//object1

   glBegin(GL_QUADS);
      glColor3f(oc1r, oc1g, oc1b);
      glVertex2f(-0.9f+rand1, 0.9f+position);
      glVertex2f( -0.85f+rand1, 0.9f+position);
      glVertex2f(-0.85f+rand1,  0.81f+position);
      glVertex2f( -0.9f+rand1,  0.81f+position);




glEnd();

      if(fabs((-.70f+b5y)-(0.9f+position))<=2.00 && fabs((-0.007f+b5x)-(-0.9f+rand1))<=.08  && (0.9f+position)<=1.9 &&  !flag1 )

         {


                        oc1g=0.18;
                        oc1b=0.08;
                    countt++;
                    flag1=!flag1;

         }

               if(fabs((-.70f+b1y)-(0.9f+position))<=2.00 && fabs((-0.007f+b1x)-(-0.9f+rand1))<=.08  && (0.9f+position)<=1.9 &&  !flag1 )

         {


                        oc1g=0.18;
                        oc1b=0.08;
                    countt++;

                    flag1=!flag1;

         }

               if(fabs((-.70f+b2y)-(0.9f+position))<=2.00 && fabs((-0.007f+b2x)-(-0.9f+rand1))<=.08 && (0.9f+position)<=1.9 &&  !flag1 )

         {


                        oc1g=0.18;
                        oc1b=0.08;
                    countt++;

                    flag1=!flag1;


         }
               if(fabs((-.70f+b3y)-(0.9f+position))<=2.00 && fabs((-0.007f+b3x)-(-0.9f+rand1))<=.08  && (0.9f+position)<=1.9 &&  !flag1 )

         {


                        oc1g=0.18;
                        oc1b=0.08;
                    countt++;

                    flag1=!flag1;

         }

               if(fabs((-.70f+b4y)-(0.9f+position))<=2.00 && fabs((-0.007f+b4x)-(-0.9f+rand1))<=.08  && (0.9f+position)<=1.9 &&  !flag1 )

         {


                        oc1g=0.18;
                        oc1b=0.08;
                    countt++;

                    flag1=!flag1;

         }


//object3
   glBegin(GL_QUADS);
      glColor3f(oc3r, oc3g, oc3b);
      glVertex2f(-0.025f+rand3, 0.9f+position);
      glVertex2f( 0.025f+rand3,  0.9f+position);
      glVertex2f(0.025f+rand3,  0.81f+position);
      glVertex2f( -0.025f+rand3, 0.81f+position);

glEnd();
    if(fabs((-.70f+b5y)-(0.9f+position))<=2.00 && fabs((-0.007f+b5x)-(-0.025f+rand3))<=.08 && (0.9f+position)<=1.9 &&  !flag3 )

         {


                        oc3r=0.0;
                        oc3g=0.18;
                        oc3b=0.08;
                    countt++;

                    flag3=!flag3;

         }

          if(fabs((-.70f+b1y)-(0.9f+position))<=2.00 && fabs((-0.007f+b1x)-(-0.025f+rand3))<=.08  && (0.9f+position)<=1.9 &&  !flag3 )

         {


                        oc3r=0.0;
                        oc3g=0.18;
                        oc3b=0.08;
                    countt++;

                    flag3=!flag3;

         }
          if(fabs((-.70f+b2y)-(0.9f+position))<=2.00 && fabs((-0.007f+b2x)-(-0.025f+rand3))<=.08  && (0.9f+position)<=1.9 &&  !flag3 )

         {


                        oc3r=0.0;
                        oc3g=0.18;
                        oc3b=0.08;
                    countt++;

                    flag3=!flag3;

         }
          if(fabs((-.70f+b3y)-(0.9f+position))<=2.00 && fabs((-0.007f+b3x)-(-0.025f+rand3))<=.08  && (0.9f+position)<=1.9 &&  !flag3 )

         {


                        oc3r=0.0;
                        oc3g=0.18;
                        oc3b=0.08;
                    countt++;

                    flag3=!flag3;

         }

          if(fabs((-.70f+b4y)-(0.9f+position))<=2.00 && fabs((-0.007f+b4x)-(-0.025f+rand3))<=.08  && (0.9f+position)<=1.9 &&  !flag3 )

         {


                        oc3r=0.0;
                        oc3g=0.18;
                        oc3b=0.08;
                    countt++;

                    flag3=!flag3;

         }

}


   glFlush();
}



int main(int argc, char** argv)
{
   glutInit(&argc, argv);
   glutInitWindowSize(380, 400);
   glutInitWindowPosition(100,100);
   glutCreateWindow("Fatao");
   glutDisplayFunc(display);
   init();
   glutKeyboardFunc(handleKeypress);
    //sndPlaySound("a.wav",SND_ASYNC);
    PlaySound("al.wav", NULL,SND_ASYNC|SND_FILENAME|SND_LOOP);
   glutTimerFunc(100, update, 0);
   glutTimerFunc(100, randdd, 0);
   glutTimerFunc(15,colour, 0);
   glutTimerFunc(5,bu5, 0);
    //sound();
   glutMainLoop();
   return 0;
}
