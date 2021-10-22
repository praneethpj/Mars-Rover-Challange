import com.nasa.rover.controller.Movement;
import com.nasa.rover.controller.compasser.OrientationLeft;
import com.nasa.rover.controller.compasser.OrientationRight;
import com.nasa.rover.dao.Compass;
import com.nasa.rover.dao.MovementDao;
import com.nasa.rover.model.Arrow;
import com.nasa.rover.model.Coordinate;

import com.nasa.rover.model.Surface;
import com.sun.org.apache.xpath.internal.functions.WrongNumberArgsException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

/**
 * @author Praneethpj
 */
class UserInputReaderTest {

    @Test
    void OrientationLeft01() {
        Compass compasserOrientationLeft=new OrientationLeft();
        Coordinate coordinate=new Coordinate();
        coordinate.setX(1);
        coordinate.setY(2);

        Arrow arrow=new Arrow(coordinate,"N");
        String sExpecting="W";
        Assertions.assertEquals(sExpecting, compasserOrientationLeft.getNextOrientation(arrow));
    }
    @Test
    void OrientationLeft02() {
        Compass compasserOrientationLeft=new OrientationLeft();
        Coordinate coordinate=new Coordinate();
        coordinate.setX(1);
        coordinate.setY(2);

        Arrow arrow=new Arrow(coordinate,"W");
        String sExpecting="S";
        Assertions.assertEquals(sExpecting, compasserOrientationLeft.getNextOrientation(arrow));
    }
    @Test
    void OrientationLeft03() {
        Compass compasserOrientationLeft=new OrientationLeft();
        Coordinate coordinate=new Coordinate();
        coordinate.setX(1);
        coordinate.setY(2);

        Arrow arrow=new Arrow(coordinate,"S");
        String sExpecting="E";
        Assertions.assertEquals(sExpecting, compasserOrientationLeft.getNextOrientation(arrow));
    }


    @Test
    void OrientationRight01() {
        Compass compasserOrientationLeft=new OrientationRight();
        Coordinate coordinate=new Coordinate();
        coordinate.setX(1);
        coordinate.setY(2);

        Arrow arrow=new Arrow(coordinate,"N");
        String sExpecting="E";
        Assertions.assertEquals(sExpecting, compasserOrientationLeft.getNextOrientation(arrow));
    }
    @Test
    void OrientationRight02() {
        Compass compasserOrientationLeft=new OrientationRight();
        Coordinate coordinate=new Coordinate();
        coordinate.setX(1);
        coordinate.setY(2);

        Arrow arrow=new Arrow(coordinate,"E");
        String sExpecting="S";
        Assertions.assertEquals(sExpecting, compasserOrientationLeft.getNextOrientation(arrow));
    }
    @Test
    void OrientationRight03() {
        Compass compasserOrientationLeft=new OrientationRight();
        Coordinate coordinate=new Coordinate();
        coordinate.setX(1);
        coordinate.setY(2);

        Arrow arrow=new Arrow(coordinate,"S");
        String sExpecting="W";
        Assertions.assertEquals(sExpecting, compasserOrientationLeft.getNextOrientation(arrow));
    }

    @Test
    void Movement01() {//head North right = Move East
        Coordinate coordinate=new Coordinate();
        coordinate.setX(1);
        coordinate.setY(2);
        Arrow arrow=new Arrow(coordinate,"N");

        String path=new OrientationRight().getNextOrientation(arrow);;



        MovementDao movements=new Movement();

        Coordinate sExpecting=new Coordinate();
        sExpecting.setY(2);
        sExpecting.setX(2);
        Coordinate sResult=movements.createMovement(coordinate,path);

        System.out.println(sResult.getY());
        Assertions.assertEquals(sExpecting.getX(), sResult.getX());
    }
    @Test
    void Movement02() {//head West left = move South
        Coordinate coordinate=new Coordinate();
        coordinate.setX(1);
        coordinate.setY(2);
        Arrow arrow=new Arrow(coordinate,"W");

        String path=new OrientationLeft().getNextOrientation(arrow);;


        MovementDao movements=new Movement();

        Coordinate sExpecting=new Coordinate();
        sExpecting.setY(1);
        sExpecting.setX(2);
        Coordinate sResult=movements.createMovement(coordinate,path);


        Assertions.assertEquals(sExpecting.getY(), sResult.getY());
    }

    @Test
    void Movement03() {//head West left = move South
        Coordinate coordinate=new Coordinate();
        coordinate.setX(1);
        coordinate.setY(2);
        Arrow arrow=new Arrow(coordinate,"W");

        String path=new OrientationLeft().getNextOrientation(arrow);;


        MovementDao movements=new Movement();

        Coordinate sExpecting=new Coordinate();
        sExpecting.setY(1);
        sExpecting.setX(2);
        Coordinate sResult=movements.createMovement(coordinate,path);

        //System.out.println(sResult.getY());

        Assertions.assertEquals(sExpecting.getY(), sResult.getY());
    }

    @Test
    void Movement04() {//head West left = move South
        Coordinate coordinate=new Coordinate();
        coordinate.setX(1);
        coordinate.setY(2);
        Arrow arrow=new Arrow(coordinate,"W");

        String path=new OrientationRight().getNextOrientation(arrow);;


        MovementDao movements=new Movement();

        Coordinate sExpecting=new Coordinate();
        sExpecting.setY(1);
        sExpecting.setX(1);
        Coordinate sResult=movements.createMovement(coordinate,path);

        // System.out.println(sResult.getX());

        Assertions.assertEquals(sExpecting.getX(), sResult.getX());
    }


    @Test
    void Validation01() {
        Coordinate coordinate=new Coordinate();
        coordinate.setX(1);
        coordinate.setY(2);
        Surface surface=new Surface(5,5);
        // System.out.println(sResult.getX());

        boolean sResult=new com.nasa.rover.valiation.InputValidation().surfaceValidate(surface,coordinate);
        Assertions.assertEquals(true, sResult);
    }

    @Test
    void Validation02() {
        String instructions="LLLM";

        boolean sResult=new com.nasa.rover.valiation.InputValidation().getInstructions(instructions);
        Assertions.assertEquals(true, sResult);
    }
    @Test
    void Validation03() throws WrongNumberArgsException {
        String orientationType="N";

        String sResult=new com.nasa.rover.valiation.InputValidation().getOrientationType(orientationType);
        Assertions.assertEquals("N", sResult);
    }
}