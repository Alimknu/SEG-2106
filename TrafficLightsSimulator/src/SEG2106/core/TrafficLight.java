package SEG2106.core;

/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.35.0.7523.c616a4dce modeling language!*/

// line 2 "model.ump"
// line 151 "model.ump"
public class TrafficLight implements EventHandler {

  // ------------------------
  // MEMBER VARIABLES
  // ------------------------

  // TrafficLight State Machines
  public enum Status {
    start, low, moderate, high
  }

  public enum StatusLow {
    Null, lowNorthAndSouthArrow, lowAndNorthAndSouthGreenWithoutArrow, lowAndNorthAndSouthYellow, lowNorthAndSouthRed,
    lowWestAndEastYellowLow
  }

  public enum StatusModerate {
    Null, moderateNorthGreenArrow, moderateNorthYellow, moderateNorthRedModerate, moderateSouthYellow, moderateSouthRed,
    moderateWestAndEastYellow
  }

  public enum StatusHigh {
    Null, highNorthGreenArrow, highNorthYellow, highNorthRed, highSouthYellow, highSouthRed, highWestGreenWithoutArrow,
    highWestAndEastYellow
  }

  private Status status;
  private StatusLow statusLow;
  private StatusModerate statusModerate;
  private StatusHigh statusHigh;
  public TrafficLightManager trafficLightManager;

  // ------------------------
  // CONSTRUCTOR
  // ------------------------

  public TrafficLight(TrafficLightManager trafficLightManager) {

    this.trafficLightManager = trafficLightManager;

    setStatusLow(StatusLow.Null);
    setStatusModerate(StatusModerate.Null);
    setStatusHigh(StatusHigh.Null);
    setStatus(Status.start);

    trafficLightManager.addEventHandler(this);
  }

  // ------------------------
  // INTERFACE
  // ------------------------

  public String getStatusFullName() {
    String answer = status.toString();
    if (statusLow != StatusLow.Null) {
      answer += "." + statusLow.toString();
    }
    if (statusModerate != StatusModerate.Null) {
      answer += "." + statusModerate.toString();
    }
    if (statusHigh != StatusHigh.Null) {
      answer += "." + statusHigh.toString();
    }
    return answer;
  }

  public Status getStatus() {
    return status;
  }

  public StatusLow getStatusLow() {
    return statusLow;
  }

  public StatusModerate getStatusModerate() {
    return statusModerate;
  }

  public StatusHigh getStatusHigh() {
    return statusHigh;
  }

  public boolean lowTraffic() {
    boolean wasEventProcessed = false;

    Status aStatus = status;
    switch (aStatus) {
      case start:
        exitStatus();
        setStatus(Status.low);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  public boolean moderateTraffic() {
    boolean wasEventProcessed = false;

    Status aStatus = status;
    switch (aStatus) {
      case start:
        exitStatus();
        setStatus(Status.moderate);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  public boolean highTraffic() {
    boolean wasEventProcessed = false;

    Status aStatus = status;
    switch (aStatus) {
      case start:
        exitStatus();
        setStatus(Status.high);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  public boolean timerGreen() {
    boolean wasEventProcessed = false;

    StatusLow aStatusLow = statusLow;
    StatusModerate aStatusModerate = statusModerate;
    StatusHigh aStatusHigh = statusHigh;
    switch (aStatusLow) {
      case lowNorthAndSouthArrow:
        exitStatusLow();
        setStatusLow(StatusLow.lowAndNorthAndSouthGreenWithoutArrow);
        wasEventProcessed = true;
        break;
      case lowAndNorthAndSouthGreenWithoutArrow:
        exitStatusLow();
        setStatusLow(StatusLow.lowAndNorthAndSouthYellow);
        wasEventProcessed = true;
        break;
      case lowNorthAndSouthRed:
        exitStatusLow();
        setStatusLow(StatusLow.lowWestAndEastYellowLow);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    switch (aStatusModerate) {
      case moderateNorthGreenArrow:
        exitStatusModerate();
        setStatusModerate(StatusModerate.moderateNorthYellow);
        wasEventProcessed = true;
        break;
      case moderateNorthRedModerate:
        exitStatusModerate();
        setStatusModerate(StatusModerate.moderateSouthYellow);
        wasEventProcessed = true;
        break;
      case moderateSouthRed:
        exitStatusModerate();
        setStatusModerate(StatusModerate.moderateWestAndEastYellow);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    switch (aStatusHigh) {
      case highNorthGreenArrow:
        exitStatusHigh();
        setStatusHigh(StatusHigh.highNorthYellow);
        wasEventProcessed = true;
        break;
      case highNorthRed:
        exitStatusHigh();
        setStatusHigh(StatusHigh.highSouthYellow);
        wasEventProcessed = true;
        break;
      case highSouthRed:
        exitStatusHigh();
        setStatusHigh(StatusHigh.highWestGreenWithoutArrow);
        wasEventProcessed = true;
        break;
      case highWestGreenWithoutArrow:
        exitStatusHigh();
        setStatusHigh(StatusHigh.highWestAndEastYellow);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  public boolean timerYellow() {
    boolean wasEventProcessed = false;

    StatusLow aStatusLow = statusLow;
    StatusModerate aStatusModerate = statusModerate;
    StatusHigh aStatusHigh = statusHigh;
    switch (aStatusLow) {
      case lowAndNorthAndSouthYellow:
        exitStatusLow();
        setStatusLow(StatusLow.lowNorthAndSouthRed);
        wasEventProcessed = true;
        break;
      case lowWestAndEastYellowLow:
        exitStatusLow();
        setStatusLow(StatusLow.lowNorthAndSouthArrow);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    switch (aStatusModerate) {
      case moderateNorthYellow:
        exitStatusModerate();
        setStatusModerate(StatusModerate.moderateNorthRedModerate);
        wasEventProcessed = true;
        break;
      case moderateSouthYellow:
        exitStatusModerate();
        setStatusModerate(StatusModerate.moderateSouthRed);
        wasEventProcessed = true;
        break;
      case moderateWestAndEastYellow:
        exitStatusModerate();
        setStatusModerate(StatusModerate.moderateNorthGreenArrow);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    switch (aStatusHigh) {
      case highNorthYellow:
        exitStatusHigh();
        setStatusHigh(StatusHigh.highNorthRed);
        wasEventProcessed = true;
        break;
      case highSouthYellow:
        exitStatusHigh();
        setStatusHigh(StatusHigh.highSouthRed);
        wasEventProcessed = true;
        break;
      case highWestAndEastYellow:
        exitStatusHigh();
        setStatusHigh(StatusHigh.highNorthGreenArrow);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  private void exitStatus() {
    switch (status) {
      case low:
        exitStatusLow();
        break;
      case moderate:
        exitStatusModerate();
        break;
      case high:
        exitStatusHigh();
        break;
    }
  }

  private void setStatus(Status aStatus) {
    status = aStatus;

    // entry actions and do activities
    switch (status) {

      case start:
        setStatusLow(StatusLow.lowNorthAndSouthArrow);
        break;
      case low:
        if (statusLow == StatusLow.Null) {
          setStatusLow(StatusLow.lowNorthAndSouthArrow);
        }
        break;
      case moderate:
        if (statusModerate == StatusModerate.Null) {
          setStatusModerate(StatusModerate.moderateNorthGreenArrow);
        }
        break;
      case high:
        if (statusHigh == StatusHigh.Null) {
          setStatusHigh(StatusHigh.highNorthGreenArrow);
        }
        break;
    }
  }

  private void exitStatusLow() {
    switch (statusLow) {
      case lowNorthAndSouthArrow:
        setStatusLow(StatusLow.Null);
        break;
      case lowAndNorthAndSouthGreenWithoutArrow:
        setStatusLow(StatusLow.Null);
        break;
      case lowAndNorthAndSouthYellow:
        setStatusLow(StatusLow.Null);
        break;
      case lowNorthAndSouthRed:
        setStatusLow(StatusLow.Null);
        break;
      case lowWestAndEastYellowLow:
        setStatusLow(StatusLow.Null);
        break;
    }
  }

  private void setStatusLow(StatusLow aStatusLow) {
    statusLow = aStatusLow;
    if (status != Status.low && aStatusLow != StatusLow.Null) {
      setStatus(Status.low);
    }

    // entry actions and do activities
    switch (statusLow) {
      case lowNorthAndSouthArrow:
        // line 13 "model.ump"
        trafficLightManager.northArrow();
        // line 14 "model.ump"
        trafficLightManager.southArrow();
        // line 15 "model.ump"
        trafficLightManager.eastRed();
        // line 16 "model.ump"
        trafficLightManager.westRed();
        break;
      case lowAndNorthAndSouthGreenWithoutArrow:
        // line 20 "model.ump"
        trafficLightManager.northGreen();
        // line 21 "model.ump"
        trafficLightManager.southGreen();
        // line 22 "model.ump"
        trafficLightManager.eastRed();
        // line 23 "model.ump"
        trafficLightManager.westRed();
        break;
      case lowAndNorthAndSouthYellow:
        // line 27 "model.ump"
        trafficLightManager.northYellow();
        // line 28 "model.ump"
        trafficLightManager.southYellow();
        // line 29 "model.ump"
        trafficLightManager.eastRed();
        // line 30 "model.ump"
        trafficLightManager.westRed();
        break;
      case lowNorthAndSouthRed:
        // line 34 "model.ump"
        trafficLightManager.northRed();
        // line 35 "model.ump"
        trafficLightManager.southRed();
        // line 36 "model.ump"
        trafficLightManager.eastGreen();
        // line 37 "model.ump"
        trafficLightManager.westGreen();
        break;
      case lowWestAndEastYellowLow:
        // line 41 "model.ump"
        trafficLightManager.westYellow();
        // line 42 "model.ump"
        trafficLightManager.eastYellow();
        // line 43 "model.ump"
        trafficLightManager.northRed();
        // line 44 "model.ump"
        trafficLightManager.southRed();
        break;
    }
  }

  private void exitStatusModerate() {
    switch (statusModerate) {
      case moderateNorthGreenArrow:
        setStatusModerate(StatusModerate.Null);
        break;
      case moderateNorthYellow:
        setStatusModerate(StatusModerate.Null);
        break;
      case moderateNorthRedModerate:
        setStatusModerate(StatusModerate.Null);
        break;
      case moderateSouthYellow:
        setStatusModerate(StatusModerate.Null);
        break;
      case moderateSouthRed:
        setStatusModerate(StatusModerate.Null);
        break;
      case moderateWestAndEastYellow:
        setStatusModerate(StatusModerate.Null);
        break;
    }
  }

  private void setStatusModerate(StatusModerate aStatusModerate) {
    statusModerate = aStatusModerate;
    if (status != Status.moderate && aStatusModerate != StatusModerate.Null) {
      setStatus(Status.moderate);
    }

    // entry actions and do activities
    switch (statusModerate) {
      case moderateNorthGreenArrow:
        // line 51 "model.ump"
        trafficLightManager.northGreenAndArrow();
        // line 52 "model.ump"
        trafficLightManager.eastRed();
        // line 53 "model.ump"
        trafficLightManager.westRed();
        // line 54 "model.ump"
        trafficLightManager.southRed();
        break;
      case moderateNorthYellow:
        // line 58 "model.ump"
        trafficLightManager.northYellow();
        // line 59 "model.ump"
        trafficLightManager.southRed();
        // line 60 "model.ump"
        trafficLightManager.eastRed();
        // line 61 "model.ump"
        trafficLightManager.westRed();
        break;
      case moderateNorthRedModerate:
        // line 65 "model.ump"
        trafficLightManager.northRed();
        // line 66 "model.ump"
        trafficLightManager.southGreenAndArrow();
        // line 67 "model.ump"
        trafficLightManager.eastRed();
        // line 68 "model.ump"
        trafficLightManager.westRed();
        break;
      case moderateSouthYellow:
        // line 72 "model.ump"
        trafficLightManager.southYellow();
        // line 73 "model.ump"
        trafficLightManager.northRed();
        // line 74 "model.ump"
        trafficLightManager.eastRed();
        // line 75 "model.ump"
        trafficLightManager.westRed();
        break;
      case moderateSouthRed:
        // line 79 "model.ump"
        trafficLightManager.southRed();
        // line 80 "model.ump"
        trafficLightManager.northRed();
        // line 81 "model.ump"
        trafficLightManager.westGreen();
        // line 82 "model.ump"
        trafficLightManager.eastGreen();
        break;
      case moderateWestAndEastYellow:
        // line 86 "model.ump"
        trafficLightManager.southRed();
        // line 87 "model.ump"
        trafficLightManager.northRed();
        // line 88 "model.ump"
        trafficLightManager.westYellow();
        // line 89 "model.ump"
        trafficLightManager.eastYellow();
        break;
    }
  }

  private void exitStatusHigh() {
    switch (statusHigh) {
      case highNorthGreenArrow:
        setStatusHigh(StatusHigh.Null);
        break;
      case highNorthYellow:
        setStatusHigh(StatusHigh.Null);
        break;
      case highNorthRed:
        setStatusHigh(StatusHigh.Null);
        break;
      case highSouthYellow:
        setStatusHigh(StatusHigh.Null);
        break;
      case highSouthRed:
        setStatusHigh(StatusHigh.Null);
        break;
      case highWestGreenWithoutArrow:
        setStatusHigh(StatusHigh.Null);
        break;
      case highWestAndEastYellow:
        setStatusHigh(StatusHigh.Null);
        break;
    }
  }

  private void setStatusHigh(StatusHigh aStatusHigh) {
    statusHigh = aStatusHigh;
    if (status != Status.high && aStatusHigh != StatusHigh.Null) {
      setStatus(Status.high);
    }

    // entry actions and do activities
    switch (statusHigh) {
      case highNorthGreenArrow:
        // line 96 "model.ump"
        trafficLightManager.northGreenAndArrow();
        // line 97 "model.ump"
        trafficLightManager.eastRed();
        // line 98 "model.ump"
        trafficLightManager.westRed();
        // line 99 "model.ump"
        trafficLightManager.southRed();
        break;
      case highNorthYellow:
        // line 103 "model.ump"
        trafficLightManager.northYellow();
        // line 104 "model.ump"
        trafficLightManager.southRed();
        // line 105 "model.ump"
        trafficLightManager.eastRed();
        // line 106 "model.ump"
        trafficLightManager.westRed();
        break;
      case highNorthRed:
        // line 110 "model.ump"
        trafficLightManager.northRed();
        // line 111 "model.ump"
        trafficLightManager.southGreenAndArrow();
        // line 112 "model.ump"
        trafficLightManager.eastRed();
        // line 113 "model.ump"
        trafficLightManager.westRed();
        break;
      case highSouthYellow:
        // line 117 "model.ump"
        trafficLightManager.southYellow();
        // line 118 "model.ump"
        trafficLightManager.northRed();
        // line 119 "model.ump"
        trafficLightManager.eastRed();
        // line 120 "model.ump"
        trafficLightManager.westRed();
        break;
      case highSouthRed:
        // line 124 "model.ump"
        trafficLightManager.southRed();
        // line 125 "model.ump"
        trafficLightManager.northRed();
        // line 126 "model.ump"
        trafficLightManager.westGreenAndArrow();
        // line 127 "model.ump"
        trafficLightManager.eastRed();
        break;
      case highWestGreenWithoutArrow:
        // line 131 "model.ump"
        trafficLightManager.southRed();
        // line 132 "model.ump"
        trafficLightManager.northRed();
        // line 133 "model.ump"
        trafficLightManager.westGreen();
        // line 134 "model.ump"
        trafficLightManager.eastGreen();
        break;
      case highWestAndEastYellow:
        // line 138 "model.ump"
        trafficLightManager.southRed();
        // line 139 "model.ump"
        trafficLightManager.northRed();
        // line 140 "model.ump"
        trafficLightManager.westYellow();
        // line 141 "model.ump"
        trafficLightManager.eastYellow();
        break;
    }
  }

  public void delete() {
  }

}

// package SEG2106.core;

/* PLEASE DO NOT EDIT THIS CODE */
/* This code was generated using the UMPLE 1.19.0.3369 modeling language! */

/*
 * // line 1 "model.ump"
 * public class TrafficLight implements EventHandler
 * {
 * 
 * @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
 * public @interface umplesourcefile{int[] line();String[] file();int[]
 * javaline();int[] length();}
 * 
 * //------------------------
 * // MEMBER VARIABLES
 * //------------------------
 * 
 * //TrafficLight State Machines
 * enum Status { northAndSouthGreen, northAndSouthYellow, northAndSouthRed,
 * westAndEastYellow }
 * private Status status;
 * 
 * //------------------------
 * // CONSTRUCTOR
 * //------------------------
 * private TrafficLightManager trafficLightManager;
 * public TrafficLight(TrafficLightManager trafficLightManager)
 * {
 * this.trafficLightManager = trafficLightManager;
 * 
 * setStatus(Status.northAndSouthGreen);
 * 
 * trafficLightManager.addEventHandler(this);
 * }
 * 
 * //------------------------
 * // INTERFACE
 * //------------------------
 * 
 * public String getStatusFullName()
 * {
 * String answer = status.toString();
 * return answer;
 * }
 * 
 * public Status getStatus()
 * {
 * return status;
 * }
 * 
 * public boolean timerGreen()
 * {
 * boolean wasEventProcessed = false;
 * 
 * Status aStatus = status;
 * switch (aStatus)
 * {
 * case northAndSouthGreen:
 * setStatus(Status.northAndSouthYellow);
 * wasEventProcessed = true;
 * break;
 * case northAndSouthRed:
 * setStatus(Status.westAndEastYellow);
 * wasEventProcessed = true;
 * break;
 * default:
 * // Other states do respond to this event
 * }
 * 
 * return wasEventProcessed;
 * }
 * 
 * public boolean timerYellow()
 * {
 * boolean wasEventProcessed = false;
 * 
 * Status aStatus = status;
 * switch (aStatus)
 * {
 * case northAndSouthYellow:
 * setStatus(Status.northAndSouthRed);
 * wasEventProcessed = true;
 * break;
 * case westAndEastYellow:
 * setStatus(Status.northAndSouthGreen);
 * wasEventProcessed = true;
 * break;
 * default:
 * // Other states do respond to this event
 * }
 * 
 * return wasEventProcessed;
 * }
 * 
 * private void setStatus(Status aStatus)
 * {
 * status = aStatus;
 * 
 * // entry actions and do activities
 * switch(status)
 * {
 * case northAndSouthGreen:
 * // line 8 "model.ump"
 * trafficLightManager.northGreen();
 * // line 9 "model.ump"
 * trafficLightManager.southGreen();
 * // line 10 "model.ump"
 * trafficLightManager.westRed();
 * // line 11 "model.ump"
 * trafficLightManager.eastRed();
 * break;
 * case northAndSouthYellow:
 * // line 16 "model.ump"
 * trafficLightManager.northYellow();
 * // line 17 "model.ump"
 * trafficLightManager.southYellow();
 * // line 18 "model.ump"
 * trafficLightManager.westRed();
 * // line 19 "model.ump"
 * trafficLightManager.eastRed();
 * break;
 * case northAndSouthRed:
 * // line 24 "model.ump"
 * trafficLightManager.northRed();
 * // line 25 "model.ump"
 * trafficLightManager.southRed();
 * // line 26 "model.ump"
 * trafficLightManager.westGreen();
 * // line 27 "model.ump"
 * trafficLightManager.eastGreen();
 * break;
 * case westAndEastYellow:
 * // line 32 "model.ump"
 * trafficLightManager.northRed();
 * // line 33 "model.ump"
 * trafficLightManager.southRed();
 * // line 34 "model.ump"
 * trafficLightManager.westYellow();
 * // line 35 "model.ump"
 * trafficLightManager.eastYellow();
 * break;
 * }
 * }
 * 
 * public void delete()
 * {}
 * 
 * @Override
 * public boolean moderateTraffic() {
 * // TODO Auto-generated method stub
 * return false;
 * }
 * 
 * @Override
 * public boolean lowTraffic() {
 * // TODO Auto-generated method stub
 * return false;
 * }
 * 
 * @Override
 * public boolean highTraffic() {
 * // TODO Auto-generated method stub
 * return false;
 * }
 * 
 * }
 */